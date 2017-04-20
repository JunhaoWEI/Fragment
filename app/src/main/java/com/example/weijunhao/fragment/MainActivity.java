package com.example.weijunhao.fragment;

import android.net.Uri;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.weijunhao.fragment.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener,
        ItemFragment.OnListFragmentInteractionListener,ItemListDialogFragment.Listener{
    private BlankFragment blankFragment;
    private ItemFragment itemFragment;
    private ItemListDialogFragment itemDialogFragment;
    private Button button,dialogFragmentBtn;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blankFragment = BlankFragment.newInstance("one", "two");
        itemFragment = new ItemFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.container, blankFragment, BlankFragment.class.getName())
                .commit();

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemFragment fragment = (ItemFragment) fragmentManager.findFragmentByTag(ItemFragment.class.getName());
                itemFragment = fragment == null ? ItemFragment.newInstance(1) : itemFragment;
                fragmentManager.beginTransaction()
                        .replace(R.id.container, itemFragment, ItemFragment.class.getName())
                        .commit();
            }
        });

        dialogFragmentBtn = (Button) findViewById(R.id.button3);
        dialogFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemListDialogFragment fragment = (ItemListDialogFragment) fragmentManager.findFragmentByTag(ItemListDialogFragment.class.getName());
                itemDialogFragment = fragment == null ? ItemListDialogFragment.newInstance(11) : itemDialogFragment;
                fragmentManager.beginTransaction()
                        .replace(R.id.container, itemDialogFragment, ItemListDialogFragment.class.getName())
                        .commit();
            }
        });
    }

    @Override
    public void onFragmentInteraction(String param) {
        Toast.makeText(this, param, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    @Override
    public void onItemClicked(int position) {
        Toast.makeText(this, position, Toast.LENGTH_SHORT).show();
    }
}
