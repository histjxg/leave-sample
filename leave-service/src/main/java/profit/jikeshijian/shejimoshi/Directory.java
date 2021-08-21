package profit.jikeshijian.shejimoshi;

import profit.jikeshijian.shejimoshi.zuhemoshi.FileSystemNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/12/下午2:37
 * @Description:
 */

public class Directory extends FileSystemNode {
    private List<FileSystemNode> subNodes = new ArrayList<>();

    public Directory(String path){
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        int  numOfFiles = 0;
        for (FileSystemNode fileOrDir: subNodes){
            numOfFiles+=fileOrDir.countNumOfFiles();
        }
        return numOfFiles;
    }

    @Override
    public long countSizeOfFiles() {
        long sizeofFles = 0;
        for (FileSystemNode fileOrDir:subNodes
             ) {
            sizeofFles+=fileOrDir.countSizeOfFiles();
        }
        return sizeofFles;
    }

    public void addSubNode(FileSystemNode fileSystemNode){
        subNodes.add(fileSystemNode);
    }

    public void removeSubNode(FileSystemNode fileOrDir){
        int size =0;
        int i =0;
        for (; i < size; ++i) {
            if (subNodes.get(i).getPath().equalsIgnoreCase(fileOrDir.getPath())){
                break;
            }
        }
        if (i<size){
            subNodes.remove(i);
        }
    }
}
