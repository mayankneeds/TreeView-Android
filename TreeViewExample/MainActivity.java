
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;


/**
 * Created by Mayank on 28-Aug-17.
 */

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Root
        TreeNode root = TreeNode.root();

        //Parent
        MyHolder.IconTreeItem nodeItem = new MyHolder.IconTreeItem(R.drawable.ic_arrow_drop_down, "Parent");
        TreeNode parent = new TreeNode(nodeItem).setViewHolder(new MyHolder(getApplicationContext(), true, MyHolder.DEFAULT, MyHolder.DEFAULT));

        //Child
        MyHolder.IconTreeItem childItem = new MyHolder.IconTreeItem(R.drawable.ic_folder, "Child");
        TreeNode child = new TreeNode(childItem).setViewHolder(new MyHolder(getApplicationContext(), false, R.layout.child, 25));

        //Sub Child
        MyHolder.IconTreeItem subChildItem = new MyHolder.IconTreeItem(R.drawable.ic_folder, "Sub Child");
        TreeNode subChild = new TreeNode(subChildItem).setViewHolder(new MyHolder(getApplicationContext(), false, R.layout.child, 50));

        //Add sub child.
        child.addChild(subChild);


        //Add child.
        parent.addChildren(child);
        root.addChild(parent);

        //Add AndroidTreeView into view.
        AndroidTreeView tView = new AndroidTreeView(getApplicationContext(), root);
        ((LinearLayout) findViewById(R.id.ll_parent)).addView(tView.getView());

    }
}
