package br.com.reduce.converter;


import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import br.com.reduce.annotation.Reduce;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * Created by Gilmar on 05/06/2017.
 */

public class Converter {


    public static <T> T toClass(Class<T> tClass, Activity activity) throws IOException {

        Class<T> clazz = tClass;
        T object = null;
        try {
            object = clazz.newInstance();
            for (Method method : clazz.getMethods()) {
                if (method.isAnnotationPresent(Reduce.class)) {
                    Reduce reduce = method.getAnnotation(Reduce.class);

                    EditText text = (EditText) activity.findViewById(reduce.value());
                    String valor = text.getText().toString();
                    if (method.getName().startsWith("set")) {
                        method.invoke(object, valor);
                    }

                }
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        return object;
    }


    public static void fromClass(Object object, Activity activity) throws IOException, InvocationTargetException, IllegalAccessException {

        Class clazz = object.getClass();
        for (Method method : clazz.getMethods()) {

            if (method.isAnnotationPresent(Reduce.class)) {
                Reduce reduce = method.getAnnotation(Reduce.class);
                TextView textView = (TextView) activity.findViewById(reduce.value());
                if (method.getName().startsWith("get")) {
                    textView.setText((method.invoke(object)).toString());
                }
            }

        }

    }

    public static View fromClass(Object object, View view) throws IOException, InvocationTargetException, IllegalAccessException {

        Class clazz = object.getClass();
        for (Method method : clazz.getMethods()) {

            if (method.isAnnotationPresent(Reduce.class)) {
                Reduce reduce = method.getAnnotation(Reduce.class);
                TextView textView = (TextView) view.findViewById(reduce.value());
                if (method.getName().startsWith("get")) {
                    textView.setText((method.invoke(object)).toString());
                }
            }

        }
        return view;
    }
}
