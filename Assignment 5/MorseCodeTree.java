import java.util.ArrayList;
import java.util.HashMap;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

    private TreeNode<String> root;

    public MorseCodeTree() {
        this.root = new TreeNode<>(null);
        this.buildTree();
        MorseCodeConverter a = new MorseCodeConverter();
    }

    @Override
    public TreeNode getRoot() {
        return this.root;
    }

    @Override
    public void setRoot(TreeNode<String> newNode) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public void insert(String code, String result) {

    }

    @Override
    public void addNode(TreeNode<String> root, String code, String letter) {

    }

    @Override
    public String fetch(String code) {
        return this.fetchNode(this.root,code);
    }



    @Override
    public String fetchNode(TreeNode<String> root, String code) {
        if(code.length() == 0){
            return root.getData();
        }
        if(code.substring(0,1).equals(".")){
            return fetchNode(root.left,code.substring(1));
        }
        if(code.substring(0,1).equals("-")){
            return fetchNode(root.right,code.substring(1));
        }
        return null;
    }

    @Override
    public LinkedConverterTreeInterface delete(String data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported");

    }

    @Override
    public LinkedConverterTreeInterface update() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported");

    }

    @Override
    public void buildTree() {
        this.actuallyBuildTree(MorseCodeConverter.letterList,this.root,0);
    }

    private void actuallyBuildTree(String[] list, TreeNode<String> root,int i) {
        if(list.length == i){
            return;
        }
        if(list[i].equals(".")){
            root.left = new TreeNode<>(MorseCodeConverter.MorseCodeMap.get(list[i]));
            this.actuallyBuildTree(list,root.left,i++);
        } else if (list[0].equals("-")) {
            root.right= new TreeNode<>(MorseCodeConverter.MorseCodeMap.get(list[i]));
            this.actuallyBuildTree(list,root.right,i++);
        }
    }

    @Override
    public ArrayList toArrayList() {
        return null;
    }

    @Override
    public void LNRoutputTraversal(TreeNode root, ArrayList list) {
        if(!(root == null)){
            LNRoutputTraversal(root.left,list);
            list.add(root.getData());
            LNRoutputTraversal(root.right,list);

        }
    }


}
