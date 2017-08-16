package br.com.reduce.convertview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.reduce.adapter.AlunoAdapter;
import br.com.reduce.model.Aluno;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    private List<Aluno> alunos;
    private Aluno aluno;
    private AlunoAdapter adapter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        intent = this.getIntent();

        alunos = new ArrayList<>();

        loadList();

        registerForContextMenu(listView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuItem item = menu.add("Informações");

        AdapterView.AdapterContextMenuInfo adapterInfo = (AdapterView.AdapterContextMenuInfo) menuInfo;
        aluno = (Aluno) listView.getItemAtPosition(adapterInfo.position);

        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(ListActivity.this, aluno.toString(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });


    }

    private void loadList(){
        if(alunoBundle() != null) {
            addAluno(alunoBundle());
        }

        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(getAdapter());
    }

    private Aluno alunoBundle(){
        return (Aluno) intent.getExtras().get("aluno");
    }

    private void addAluno(Aluno aluno){
        alunos.add(aluno);
    }

    private AlunoAdapter getAdapter(){
        return adapter = new AlunoAdapter(this, alunos);
    }


}
