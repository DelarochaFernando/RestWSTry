package com.example.jmata.restwstry;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private Button btnGETALL, btnGET_ONE, btnWSDELETE, btnWSPOST, btnUpdate;
    private EditText editId, editIdPers, editNombre, editApellido1, editApellido2, editNacimiento,
            editsex;
    private TextView txtResponse;
    private String URL_WS, result, jsonConv;
    private Persona persona;
    private LinearLayout linearInfoPersona;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGETALL = (Button)findViewById(R.id.btnGETALL);
        btnGET_ONE = (Button)findViewById(R.id.btnGET_ONE);
        btnWSDELETE = (Button)findViewById(R.id.btnWSDELETE);
        btnWSPOST = (Button)findViewById(R.id.btnWSPOST);
        btnUpdate = (Button)findViewById(R.id.btnUpdate);
        editId = (EditText)findViewById(R.id.editId);
        editIdPers = (EditText)findViewById(R.id.editIdPers);
        editNombre  = (EditText)findViewById(R.id.editNombre);
        editApellido1 = (EditText)findViewById(R.id.editApellido1);
        editApellido2  = (EditText)findViewById(R.id.editApellido2);
        editNacimiento  = (EditText)findViewById(R.id.editNacimiento);
        editsex = (EditText)findViewById(R.id.editsex);
        linearInfoPersona = (LinearLayout)findViewById(R.id.linearInfoPersona);
        txtResponse = (TextView)findViewById(R.id.txtResponse);

        URL_WS = "";

        btnGETALL.setOnClickListener(new View.OnClickListener() {
            int method = 1;
            @Override
            public void onClick(View v) {
                URL_WS = "http://productos.winstondata.com/ws_rest/api/personas/";
                //txtResponse.setText(result);
                //Log.i("Ws Response:", result);
                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        try {
                            result = requestContent(URL_WS, method);
                        }catch (Exception e){
                            e.printStackTrace();
                        }finally {
                            Message message = new Message();
                            Bundle bundle = new Bundle();
                            bundle.putInt("id", 0);
                            message.setData(bundle);
                            handler.sendMessage(message);
                        }
                    }
                };
                thread.start();


            }
        });

        btnGET_ONE.setOnClickListener(new View.OnClickListener() {
            int method = 2;
            @Override
            public void onClick(View v) {
                editId.setVisibility(View.VISIBLE);
                String numId = editId.getText().toString();
                URL_WS = "http://productos.winstondata.com/ws_rest/api/personas/"+numId;

                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        try {
                           result = requestContent(URL_WS, method);
                        }catch (Exception e){
                            e.printStackTrace();
                        }finally {
                            Message message = new Message();
                            Bundle bundle = new Bundle();
                            bundle.putInt("id", 0);
                            message.setData(bundle);
                            handler.sendMessage(message);
                        }
                    }
                };
                thread.start();
            }
        });

        btnWSDELETE.setOnClickListener(new View.OnClickListener() {
            int method = 3;
            @Override
            public void onClick(View v) {
                String numId = editId.getText().toString();
                URL_WS = "http://productos.winstondata.com/ws_rest/api/personas/"+numId;

                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        try {
                            result = requestContent(URL_WS, method);
                        }catch (Exception e){
                            e.printStackTrace();
                        }finally {
                            Message message = new Message();
                            Bundle bundle = new Bundle();
                            bundle.putInt("id", 0);
                            message.setData(bundle);
                            handler.sendMessage(message);
                        }
                    }
                };
                thread.start();
            }
        });

        btnWSPOST.setOnClickListener(new View.OnClickListener() {
            int method = 4;
            @Override
            public void onClick(View v) {
                //linearInfoPersona.setVisibility(View.VISIBLE);
                String IdP = editIdPers.getText().toString();
                String nom = editNombre.getText().toString();
                String ap1 = editApellido1.getText().toString();
                String ap2 = editApellido2.getText().toString();
                String nac = editNacimiento.getText().toString();
                String sex = editsex.getText().toString();

                persona = new Persona(IdP,nom,ap1,ap2,nac,sex);
                Gson gson = new Gson();
                jsonConv = gson.toJson(persona);
                URL_WS ="http://productos.winstondata.com/ws_rest/api/personas/";
                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        try {
                            result = requestContent(URL_WS, method);
                        }catch (Exception e){
                            e.printStackTrace();
                        }finally {
                            Message message = new Message();
                            Bundle bundle = new Bundle();
                            bundle.putInt("id", 0);
                            message.setData(bundle);
                            handler.sendMessage(message);
                        }
                    }
                };
                thread.start();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            int method = 5;
            @Override
            public void onClick(View v) {
                String numId = editId.getText().toString();
                URL_WS = "http://productos.winstondata.com/ws_rest/api/personas/"+numId;

                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        try {
                            result = requestContent(URL_WS, method);
                        }catch (Exception e){
                            e.printStackTrace();
                        }finally {
                            Message message = new Message();
                            Bundle bundle = new Bundle();
                            bundle.putInt("id", 0);
                            message.setData(bundle);
                            handler.sendMessage(message);
                        }
                    }
                };
                thread.start();
            }
        });

    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int id = msg.getData().getInt("id");
            if(id == 0){
                Log.i("Ws Response:", result);
                txtResponse.setText(result);
                result = null;
            }
        }
    };

    private String requestContent(String URL, int methodId){


        switch(methodId){

            case 1:
                //Get All
                try{

                    HttpClient client = new DefaultHttpClient();
                    HttpGet httpgetrequest = new HttpGet(URL);
                    HttpResponse response = null;
                    InputStream istream = null;

                    response = client.execute(httpgetrequest);
                    HttpEntity entity = response.getEntity();
                    istream = entity.getContent();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(istream));
                    StringBuilder sb = new StringBuilder();
                    String line = null;

                    while((line = reader.readLine())!= null){
                        sb.append(line + "\n");
                    }

                    result = sb.toString();
                    Log.i("Ws Response",result);

                }catch (Exception e){
                    e.printStackTrace();
                    result = "Error";
                }

                return result;
                //break;
            case 2:
                try{
                    //Get one record
                    HttpClient client = new DefaultHttpClient();
                    HttpGet httpgetrequest = new HttpGet(URL);
                    HttpResponse response = null;
                    InputStream istream = null;

                    response = client.execute(httpgetrequest);
                    HttpEntity entity = response.getEntity();
                    istream = entity.getContent();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(istream));
                    StringBuilder sb = new StringBuilder();
                    String line = null;

                    while((line = reader.readLine())!= null){
                        sb.append(line + "\n");
                    }

                    result = sb.toString();
                    Log.i("Ws Response",result);

                }catch (Exception e){
                    e.printStackTrace();
                    result = "Error";
                }

                return result;
                //break;

            case 3:
                try{
                    //Delete one record
                    HttpClient client = new DefaultHttpClient();
                    HttpDelete deleterequest = new HttpDelete(URL);
                    HttpResponse response = null;
                    InputStream istream = null;

                    response = client.execute(deleterequest);
                    HttpEntity entity = response.getEntity();
                    istream = entity.getContent();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(istream));
                    StringBuilder sb = new StringBuilder();
                    String line = null;

                    while((line = reader.readLine())!= null){
                        sb.append(line + "\n");
                    }

                    result ="Record Deleted\n" +sb.toString();
                    Log.i("Ws Response",sb.toString());

                }catch (Exception e){
                    e.printStackTrace();
                    result = "Error";
                }

                return result;
                //break;
            case 4:
                try{
                    //Insert one record
                    //byte[]datos = jsonConv.getBytes();
                    HttpClient client = new DefaultHttpClient();
                    HttpPost postrequest = new HttpPost(URL);
                    StringEntity params = new StringEntity(jsonConv.toString());
                    postrequest.addHeader("content-type", "application/json");
                    postrequest.setEntity(params);

                    HttpResponse response = client.execute(postrequest);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),"UTF8"));

                    StringBuilder sb = new StringBuilder();
                    String line;

                    while((line = reader.readLine())!= null){
                        sb = sb.append(line);
                    }

                    if(!sb.equals("")){
                        result ="Record Inserted\n" +sb.toString();
                        Log.i("Ws Response",sb.toString());
                    }else {
                        result = "null";
                    }


                }catch (Exception e){
                    e.printStackTrace();
                    result = "Error";
                }

                return result;
                //break;
            case 5:
                //Update one record
                try{
                    HttpClient client = new DefaultHttpClient();
                    HttpPost postrequest = new HttpPost(URL);
                    StringEntity params = new StringEntity(jsonConv);
                    postrequest.addHeader("content-type","application/json");
                    postrequest.setEntity(params);

                    HttpResponse response = client.execute(postrequest);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),"UTF8"));

                    StringBuilder sb = new StringBuilder();
                    String line;

                    while((line = reader.readLine())!= null){
                        sb = sb.append(line);
                    }

                    result ="Record Updated\n" +sb.toString();
                    Log.i("Ws Response",sb.toString());

                }catch (Exception e){
                    e.printStackTrace();
                    result = "Error";
                }

                return result;
            //break;
            default:
                return "Error";
        }



    }
}
