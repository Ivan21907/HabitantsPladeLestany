package cat.dam.ivan.habitantspladelestany;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Array dels municipis de la comarca del Pla de L'estany
    String [] municipis = new String[]{"Banyoles", "Camós", "Cornellà del Terri",
            "Crespià", "Esponellà", "Fontcoberta", "Palol de Revardit",
            "Porqueres", "Sant Miquel de Campmajor", "Serinyà", "Vilademuls"};

    //Array del número d'habitants de cada població
    String [] num_Habitants = new String[]{"17451", "698", "2106", "247", "441", "1212", "459",
            "4208", "218", "1084", "769"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btn_1 = findViewById(R.id.bt_1);
        final TextView num_hab = findViewById(R.id.num_hab);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, municipis);
        AutoCompleteTextView atv_Municipi = (AutoCompleteTextView) findViewById(R.id.atv_1);
        atv_Municipi.setAdapter(adapter);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //bucle que recorre totes les posicions de les dos arrays
                for(int i = 0; i < municipis.length; i++)
                {
                    if(municipis[i].equals(atv_Municipi.getText().toString()))
                    {
                        num_hab.setText(num_Habitants[i]);
                    }
                }
            }
        });
    }
}