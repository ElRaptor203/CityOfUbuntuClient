package com.example.cityofubuntu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.cityofubuntu.adapter.AdapterHome1;
import com.example.cityofubuntu.data.DataHome;
import com.example.cityofubuntu.data.Donnee;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import tech.gusavila92.websocketclient.WebSocketClient;

public class HomeActivity extends AppCompatActivity implements AdapterHome1.OnItemClickListener  {

    private static RecyclerView recyclerView1;
    private static AdapterHome1 adapter1;
    private RecyclerView.LayoutManager layoutManager1;
    public static ArrayList<DataHome> data1 = new ArrayList<DataHome>() ;
    public static ArrayList<DataHome> data2 = new ArrayList<DataHome>() ;

    public static WebSocketClient webSocketClient;
    public static boolean etats = false, charge_other_list = false, listinit = false;
    public static boolean full = false,listinitdata2 = false,init1 = true,listinitdata = true;
    public static int nbre_article_recu_du_serveur = 0;
    public static ProgressDialog progressDoalog;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        etats = true;
        createWebSocketClient();

        recyclerView1 = (RecyclerView) findViewById(R.id.my_recycler_view_home1);
        recyclerView1.setHasFixedSize(true);
        layoutManager1 = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());
        adapter1 = new AdapterHome1(this,data1);

        context = getApplicationContext();

        if (data1.size() == 0){
            init1 = true;

            progressDoalog = new ProgressDialog(getApplicationContext());
           progressDoalog.setTitle("Chargement des rayons Veuillez patienter ...");
            progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDoalog.setIndeterminate(true);
            progressDoalog.setCancelable(true);
//            progressDoalog.show();
        }

            recyclerView1.setAdapter(adapter1);
            charge_other_list = false;

//        adapter1.setOnItemClickListener(getClass());
//        adapter2.setOnItemClickListener((AdapterHome1.OnItemClickListener) HomeActivity.this);

        if (data1.size() != 0 ){

            adapter1 = new AdapterHome1(getApplicationContext(),data1);
            recyclerView1.setAdapter(adapter1);
            adapter1.setOnItemClickListener(HomeActivity.this);
        }

    }


    private void createWebSocketClient() {
        URI uri;
        try {
            // Connect to local host
            uri = new URI(Donnee.PATHWEBSOKET);
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }
        webSocketClient = new WebSocketClient(uri) {
            @Override
            public void onOpen() {
                Log.i("-----------","----------------------------");
                Log.i("WebSocket HomeFragment", "Session HomeFragment is starting ");
                Log.i("-----------","----------------------------");

                    webSocketClient.send("debut"+"①"+data1.size()+"②");
                    listinitdata2 = true;

            }

            @Override
            public void onTextReceived(String s) {
                String message = s;

                if (listinitdata){
//                    getActivity().runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(context,"HomeFragment j'initiale data: "+data.size(),Toast.LENGTH_SHORT).show();
//                        }
//                    });
                    listinitdata = false;
                    data1 = new ArrayList<DataHome>() ;
                    init1 = true;
                }

                if (listinitdata2){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
//                            Toast.makeText(context,"HomeFragment j'initiale data2: "+data.size(),Toast.LENGTH_SHORT).show();
                        }
                    });
                    listinitdata2 = false;
                    data2 = new ArrayList<DataHome>() ;
                }
                Log.i("WebSocket HomeFragment", "Message received from home fragment");
               runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String  message0 = message.substring(0,message.indexOf("①"));


                        if (message0.equals("table_rayon_is_empty_in_database")){

                        }

                        if (message0.equals("nombre_de_rayon_egale")){

                        }

                        if (message0.equals("send_data_to_client")){
                            String  message1 = message.substring(message0.length()+1,message.indexOf("②"));
                            String  message2 = message.substring(message1.length()+message0.length()+2,message.indexOf("③"));
                            String  message3 = message.substring(message2.length()+message1.length()+message0.length()+3,message.indexOf("④"));
                            String  message4 = message.substring(message3.length()+message2.length()+message1.length()+message0.length()+4,message.indexOf("⑤"));

                            Log.i("HomeFragment_Tag_13r1", "message : "+message);
                            Log.i("HomeFragment_Tag_13r2", "message0 : "+message0);
                            Log.i("HomeFragment_Tag_13r3", "message1 : "+message1);
                            Log.i("HomeFragment_Tag_13r4", "message2 : "+message2);
                            Log.i("HomeFragment_Tag_13r5", "message3 : "+message3);
                            int list_size = Integer.parseInt(message4);
                            int id = Integer.parseInt(message1);
                            Log.i("HomeFragment_Tag2_13r1", "taille de la liste : "+list_size);

                            if (!full){
                                Log.i("HomeFragment_full_false", "chargement de data 2");
                                data2.add(new DataHome(id,message2,message3));
                            }

                            if (init1){
                                Log.i("HomeFragment_init1_true", "chargement de data ");
                                data1.add(new DataHome(id,message2,message3));
                                adapter1 = new AdapterHome1(getApplicationContext(),data1);
                                recyclerView1.setAdapter(adapter1);
                                adapter1.setOnItemClickListener(HomeActivity.this);
                            }
                            Log.i("HomeFragment_Tag_1dfdr1", "taille de la liste data  : "+data1.size());
                            Log.i("HomeFragment_dmn_13r1", "taille de la liste   : "+list_size);
                            nbre_article_recu_du_serveur = nbre_article_recu_du_serveur + 1;
                            Log.i("-----------","----------------------------");
                            Log.i("HomeFragment_nbe_server","le serveur a evoyer : "+nbre_article_recu_du_serveur+" articles sur : "+list_size);
                            Log.i("-----------","----------------------------");

                            if (data2.size() == list_size){
                                full = true;
                                if (init1){
                                    full = false;
                                    init1 = false;
                                }
                                if (full){
                                    Log.i("xxxxxxxxxxxxxxxxxxx","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                                    Log.i("HomeFragment_dinaniq", "je charge dinamiquement l'article");
                                    Log.i("xxxxxxxxxxxxxxxxxxx","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                                    full = false;
                                    data1 = new ArrayList<DataHome>() ;
                                    data1 = (ArrayList<DataHome>)data2.clone();
                                    data2 = new ArrayList<DataHome>() ;
                                    adapter1 = new AdapterHome1(getApplicationContext(),data1);
                                    recyclerView1.setAdapter(adapter1);
                                    adapter1.setOnItemClickListener(HomeActivity.this);
                                }
                                Log.i("HomeFragment_fff_13r1", "fin du chargement des article");
                                nbre_article_recu_du_serveur = 0;
                                progressDoalog.dismiss();
                            }
                        }

                    }
                });

            }

            @Override
            public void onBinaryReceived(byte[] data) {
            }

            @Override
            public void onPingReceived(byte[] data) {

            }

            @Override
            public void onPongReceived(byte[] data) {

            }

            @Override
            public void close() {
                super.close();
            }


            @Override
            public void onException(Exception e)
            {
                //  etats =true;
                Log.i("onException", "error onException");
            }

            @Override
            public void onCloseReceived() {
                Log.i("WebSocket", "onCloseReceived ");
            }
        };

        webSocketClient.setConnectTimeout(60000);
        webSocketClient.setReadTimeout(30000);
        webSocketClient.enableAutomaticReconnection(0);
        webSocketClient.connect();
    }

    @Override
    public void onItemClick(int position) {

    }
}
