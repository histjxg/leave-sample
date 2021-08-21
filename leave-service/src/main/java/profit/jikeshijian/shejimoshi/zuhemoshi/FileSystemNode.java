package profit.jikeshijian.shejimoshi.zuhemoshi;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/12/下午2:32
 * @Description:
 */

public abstract class FileSystemNode {
    protected String path;
    public FileSystemNode(String path){
        this.path = path;
    }
    public abstract int countNumOfFiles();
    public abstract long countSizeOfFiles();

    public String getPath(){
        return path;
    }

}
