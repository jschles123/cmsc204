import java.util.ArrayList;
import java.util.HashMap;

/**
 * MorseCodeTree represents a binary tree specifically for decoding Morse code into letters.
 * Each node in the tree represents a letter in the Morse code system.
 * Implements the LinkedConverterTreeInterface.
 *
 * @author Joshua Schlesinger-Guevara
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

    /**
     * List of letters corresponding to Morse code sequences.
     */
    public String[] letterList = {
            "e", "t",          // length 1
            "a", "i", "m", "n", "d", "g", "k", "o", "r", "s", "u", "w", // length 2
            "b", "c", "f", "h", "j", "l", "p", "q", "v", "x", "y", "z"  // length 3 or 4
    };

    /**
     * List of Morse code sequences corresponding to the letters in letterList.
     */
    public String[] codeList = {
            ".", "-",          // length 1
            ".-", "..", "--", "-.", "-..", "--.", "-.-", "---", ".-.", "...", "..-", ".--", // length 2
            "-...", "-.-.", "..-.", "....", ".---", ".-..", ".--.", "--.-", "...-", "-..-", "-.--", "--.." // length 3 or 4
    };

    /**
     * Root node of the Morse code tree.
     */
    private TreeNode<String> root;

    /**
     * Constructor initializes the root and builds the Morse code tree.
     */
    public MorseCodeTree() {
        this.root = new TreeNode<String>(new String());
        this.buildTree();
    }

    /**
     * Returns the root of the tree.
     *
     * @return TreeNode representing the root
     */
    @Override
    public TreeNode getRoot() {
        return this.root;
    }

    /**
     * Sets a new root for the tree.
     *
     * @param newNode TreeNode to set as the new root
     */
    @Override
    public void setRoot(TreeNode<String> newNode) {
        newNode.setLeft(this.root.getLeft());
        newNode.setRight(this.root.getRight());
        this.root = newNode;
    }

    /**
     * Inserts a new node into the tree based on the Morse code.
     *
     * @param code Morse code representing the path in the tree
     * @param result Letter to insert at the specified code location
     */
    @Override
    public void insert(String code, String result) {
        this.addNode(this.root,code,result);
    }

    /**
     * Adds a new node to the tree at the correct location based on the Morse code.
     *
     * @param root Starting node
     * @param code Morse code for the path
     * @param letter Letter to insert
     */
    @Override
    public void addNode(TreeNode<String> root, String code, String letter) {
        if(code.length() < 1){
            throw new NullPointerException();
        }
        if(code.length() == 1) {
            if(code.equals("-")) {
                root.right = new TreeNode<String>(letter);
            }else{
                root.left = new TreeNode<String>(letter);
            }
        }else {
            if (code.substring(0, 1).equals("-")) {
                this.addNode(root.right, code.substring(1), letter);
            } else {
                this.addNode(root.left, code.substring(1), letter);
            }
        }

    }

    /**
     * Retrieves the letter associated with the given Morse code.
     *
     * @param code Morse code to look up
     * @return Letter associated with the Morse code
     */
    @Override
    public String fetch(String code) {
        return this.fetchNode(this.root,code);
    }

    /**
     * Recursively retrieves a node’s data based on the Morse code path.
     *
     * @param root Current node
     * @param code Remaining Morse code
     * @return Letter associated with the path
     */
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

    /**
     * Deletes a node from the tree. Not supported in this implementation.
     *
     * @param data The data to delete
     * @return Updated tree
     * @throws UnsupportedOperationException Always thrown
     */
    @Override
    public LinkedConverterTreeInterface delete(String data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported");
    }

    /**
     * Updates the tree. Not supported in this implementation.
     *
     * @return Updated tree
     * @throws UnsupportedOperationException Always thrown
     */
    @Override
    public LinkedConverterTreeInterface update() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported");
    }

    /**
     * Builds the Morse code tree from the predefined lists of letters and codes.
     */
    @Override
    public void buildTree() {
        for(int i=0;i< 26;i++){
            this.insert(this.codeList[i],this.letterList[i]);
        }
        System.out.println(this.fetch("..-"));
    }

    /**
     * Returns an ArrayList of all elements in the tree using LNR (in-order) traversal.
     *
     * @return ArrayList containing the letters in in-order traversal
     */
    @Override
    public ArrayList toArrayList() {
        ArrayList<String> list = new ArrayList<>();
        LNRoutputTraversal(this.root, list);
        return list;
    }

    /**
     * Performs an in-order traversal (Left-Node-Right) and adds nodes' data to a list.
     *
     * @param root Starting node for traversal
     * @param list List to collect node data
     */
    @Override
    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
        if(!(root == null)){
            LNRoutputTraversal(root.left,list);
            list.add(root.getData());
            LNRoutputTraversal(root.right,list);
        }
    }
}
