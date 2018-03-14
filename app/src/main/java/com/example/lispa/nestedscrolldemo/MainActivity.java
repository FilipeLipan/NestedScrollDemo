package com.example.lispa.nestedscrolldemo;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ExpandableListAdapter;
        import android.widget.ExpandableListView;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (RecyclerView) findViewById(R.id.expandableListView);

        Button change = (Button) findViewById(R.id.change);
        Button expand = (Button) findViewById(R.id.expand);

        HashMap<String, List<String>> expandableListDetail = ExpandableListDataPump.getData();
        final ArrayList<String> expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());

        final Adapter adapter = new Adapter(expandableListTitle);

        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));


        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.remove(2);
                adapter.remove(1);
                adapter.notifyItemRangeChanged(0,1,true);
            }
        });

        expand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.addData(expandableListTitle);
                adapter.notifyItemRangeChanged(0,3);
            }
        });
    }

}