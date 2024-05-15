interface FileSystemComponent {
    long getSize();
}
import java.util.ArrayList;
import java.util.List;

class File implements FileSystemComponent {
    private String name;
    private long size;

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    public long getSize() {
        return size;
    }
}

class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components;

    public Directory(String name) {
        this.name = name;
        components = new ArrayList<>();
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        components.remove(component);
    }

    public long getSize() {
        long totalSize = 0;
        for (FileSystemComponent component : components) {
            totalSize += component.getSize();
        }
        return totalSize;
    }
}
public class Main {
    public static void main(String[] args) {
        File file1 = new File("file1.txt", 100);
        File file2 = new File("file2.txt", 200);

        Directory dir1 = new Directory("Folder1");
        dir1.addComponent(file1);
        dir1.addComponent(file2);

        File file3 = new File("file3.txt", 150);
        Directory dir2 = new Directory("Folder2");
        dir2.addComponent(file3);

        dir1.addComponent(dir2);

        System.out.println("Size of Folder1: " + dir1.getSize() + " bytes");
    }
}
