package software.ulpgc.imageviewer;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FolderPathImageLoader implements ImageLoader{
    private final List<File> files;
    private boolean valid = false;
    private static final String[] imageExtensions = new String[]{"jpg", "png"};

    public FolderPathImageLoader(File folder) {
        if(folder.exists()) {
            this.files = validation(folder.listFiles());
        } else {
            this.files = null;
        }
    }

    private List<File> validation(File[] files) {
        List<File> finalList = Arrays.stream(files).
                sequential().
                filter(this::isAnImage).
                collect(Collectors.toList());

        if (finalList.size() >= 0) {this.valid = true;}
        return finalList;
    }

    private boolean isAnImage(File s) {
        for(String pattern : imageExtensions){
            if(s.toString().contains(pattern)){return true;}
        }
        return false;
    }

    public String filesToString() {
        StringBuilder result = new StringBuilder();
        for (File file : files) {
            result.append(file.toString()).append("\n");
        }
        return result.toString();
    }

    public String filesToString2() {
        StringBuilder result = new StringBuilder();
        for (File file : files) {
            result.append(file.getAbsolutePath()).append("\n");
        }
        return result.toString();
    }

    @Override
    public Image load() {
        if(!valid){
            return linkImages();
        } else {return null;}
    }

    private Image linkImages() {
        Image first;
        for(int i = 0;i<files.size();i++){
            first = new Image(){
                @Override
                public String path() {
                    return files.get(i).toString();
                }

                @Override
                public Image next() {
                    if(i==files.size()-1){}
                    return null;
                }

                @Override
                public Image prev() {
                    return null;
                }
            }
        }
    }
}
