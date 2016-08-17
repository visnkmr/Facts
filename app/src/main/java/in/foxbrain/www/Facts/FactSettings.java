package in.foxbrain.www.Facts;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class FactSettings extends ActionBarActivity {

    public String filename = "MySharedString";
    SharedPreferences someData;
    String wfact = "factfile";
    SharedPreferences setfact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.factsettings);
        someData = getSharedPreferences(filename,0);
        final ListView settingsmenu = (ListView)findViewById(R.id.listView);
        List<String> your_array_list = new ArrayList<String>();
        your_array_list.add("Enter a fact number");
        your_array_list.add("Change background color");
        your_array_list.add("Made by: SortedCode");
        your_array_list.add("Email Developer");
        your_array_list.add("Visit Facts! Homepage");
        your_array_list.add("Help");
        your_array_list.add("Version: 0.4");
        your_array_list.add("Fix Speech");
//        your_array_list.add("Send fact to widget");

        settingsmenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(FactSettings.this);
                    alertDialog.setIcon(R.drawable.ic_launcher);
                    alertDialog.setTitle("Enter Fact number");
                    final EditText input = new EditText(FactSettings.this);
                    input.setInputType(InputType.TYPE_CLASS_NUMBER);
                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                    input.setLayoutParams(lp);
                    alertDialog.setView(input);
                    alertDialog.setPositiveButton("Take me to the fact",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            int setfactnum = 0;
                            try {
                                setfactnum = Integer.parseInt(input.getText().toString());
                            } catch (NumberFormatException ex)
                            {
                                Toast.makeText(getApplicationContext(),"Please enter a valid fact number!", Toast.LENGTH_SHORT).show();
                            }

                            String factno = "nfactfile";
                            SharedPreferences factcount;
                            factcount = getSharedPreferences(factno,0);
                            Integer fnocheck = factcount.getInt("factcount",1);
                            fnocheck++;
                            if (setfactnum<fnocheck && setfactnum>0 )
                            { SharedPreferences.Editor editor = someData.edit();
                                editor.putInt("ivalue", setfactnum-1 );
                                editor.commit();
                                Intent myIntent1 = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(myIntent1);
                            } else {
                                Toast toast = Toast.makeText(getApplicationContext(),"Enter a valid fact number!",Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER | Gravity.CENTER, 10, 0);
                                toast.show();
                            }
                        }
                    });
                    alertDialog.show();
                }
                else if(position==1)
                {
                    final AlertDialog.Builder alertDialog = new AlertDialog.Builder(FactSettings.this);
                    alertDialog.setIcon(R.drawable.ic_launcher);
                    alertDialog.setTitle("Choose a Background colour");
                    final Spinner bc = (Spinner) new Spinner(FactSettings.this);
                    alertDialog.setView(bc);
                    String[] bcs={"Choose Color","Random(Default)","Aqua","Purple","Lavender","Orange","Red","Mauve","Green","Blue"};
                    ArrayAdapter<String> bcc = new ArrayAdapter<String>(FactSettings.this,android.R.layout.simple_spinner_dropdown_item,bcs);
                    bcc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    bc.setAdapter(bcc);
                    bc.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String bcselect = "usercolor";
                            SharedPreferences bcsp;
                            bcsp = getSharedPreferences(bcselect,0);
                            SharedPreferences.Editor bceditor = bcsp.edit();
                            if(position==8){
                                Toast.makeText(getApplicationContext(),"Green set as background color !!", Toast.LENGTH_SHORT).show();
                                bceditor.putInt("bcvalue", position );
                                bceditor.commit();
                            }
                            if(position==9){
                                Toast.makeText(getApplicationContext(),"Blue set as background color !!", Toast.LENGTH_SHORT).show();
                                bceditor.putInt("bcvalue", position );
                                bceditor.commit();
                            }
                            if(position==2){
                                Toast.makeText(getApplicationContext(),"Aqua set as background color !!", Toast.LENGTH_SHORT).show();
                                bceditor.putInt("bcvalue", position );
                                bceditor.commit();
                            }
                            if(position==3){
                                Toast.makeText(getApplicationContext(),"Purple set as background color !!", Toast.LENGTH_SHORT).show();
                                bceditor.putInt("bcvalue", position );
                                bceditor.commit();
                            }
                            if(position==4){
                                Toast.makeText(getApplicationContext(),"Lavender set as background color !!", Toast.LENGTH_SHORT).show();
                                bceditor.putInt("bcvalue", position );
                                bceditor.commit();
                            }
                            if(position==5){
                                Toast.makeText(getApplicationContext(),"Orange set as background color !!", Toast.LENGTH_SHORT).show();
                                bceditor.putInt("bcvalue", position );
                                bceditor.commit();
                            }
                            if(position==6){
                                Toast.makeText(getApplicationContext(),"Red set as background color !!", Toast.LENGTH_SHORT).show();
                                bceditor.putInt("bcvalue", position );
                                bceditor.commit();
                            }
                            if(position==7){
                                Toast.makeText(getApplicationContext(),"Mauve set as background color !!", Toast.LENGTH_SHORT).show();
                                bceditor.putInt("bcvalue", position );
                                bceditor.commit();
                            }
                            if(position==1){
                                Toast.makeText(getApplicationContext(),"Random set as background color !!", Toast.LENGTH_SHORT).show();
                                bceditor.putInt("bcvalue", position );
                                bceditor.commit();
                            }
                            if(position==0){
                                Toast.makeText(getApplicationContext(),"Choose a color !!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            Toast toast = Toast.makeText(getApplicationContext(),"Enter a valid Background color!",Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER | Gravity.CENTER, 10, 0);
                            toast.show();
                        }
                    });


                    alertDialog.show();
                }
                else if(position==2)
                {
                    String url = "http://sortedcode.blogspot.in";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
                else if(position==3)
                {
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                            "mailto","visnk2@gmail.com", null));
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "");
                    startActivity(Intent.createChooser(emailIntent, "Send email..."));
                }
                else if(position==4)
                {
                    String url = "http://factsbysortedcode.blogspot.in";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
                else if(position==5)
                {
                    Intent intent = new Intent(getApplicationContext(),intro4.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                }
                else if(position==7)
                {
                    new AlertDialog.Builder(FactSettings.this)
                            .setIcon(R.drawable.speak)
                            .setTitle("Fix Speech")
                            .setMessage("If you dont hear any voice go to" +
                                    "                        \n->setting (of your android device)" +
                                    "                        \n->accessibility" +
                                    "                        \n->text-to-speech output" +
                                    "                        \n->gear icon (settings icon) near 'Google Text-to-speech engine'" +
                                    "                        \n->Language->English(United States)")
                            .setPositiveButton("ok", null)
                            .show();
                }
                else if(position==6){
                    startActivity(new Intent(getApplicationContext(),facts.class));
                }

            }
        });

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,your_array_list );

        settingsmenu.setAdapter(arrayAdapter);
    }

    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }

}
