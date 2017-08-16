package br.com.reduce.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import br.com.reduce.model.Aluno;
import br.com.reduce.converter.Converter;
import br.com.reduce.convertview.R;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by Gilmar on 07/06/2017.
 */

public class AlunoAdapter extends BaseAdapter {

    private final Context context;
    private List<Aluno> alunos;
    private LayoutInflater inflater;

    public AlunoAdapter(Context context,  List<Aluno> alunos) {

        this.context = context;
        this.alunos = alunos;

    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Aluno getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Long.valueOf(alunos.get(position).getTelefone());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Aluno aluno = alunos.get(position);

        inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.activity_display, null);

        try {
           v = Converter.fromClass(aluno, v);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return v;
    }
}
