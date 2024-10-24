package es.travelworld.www.a4intents;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.renderscript.ScriptGroup;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import es.travelworld.www.a4intents.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    Spinner edades;
    TextInputEditText apellido,nombre;
    Button meapunto;
    TextView condiciones;
    ImageButton ibcamara;
    ImageView ivregistro;

    ActivityMainBinding binding;

    private ImageView imageView;
    private ActivityResultLauncher <Intent> takePictureLauncher;

    TextWatcher textWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //setContentView(R.layout.activity_main);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Usuario usuario=new Usuario("","","");
        usuario.setOpcionesEdad(edades);
        binding.setUser(usuario);



        nombre.addTextChangedListener(textWatcher);
        apellido.addTextChangedListener(textWatcher);
        meapunto.setEnabled(false);

        binding.btMeapunto.setOnClickListener((view )->{
            Usuario usuario1=new Usuario(binding.textinputedittexNombre.toString(),binding.textinputedittexApellido.toString(),binding.spEdad.toString());
        });


        binding.ibCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    takePictureLauncher.launch(takePictureIntent);
                }
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.edades, android.R.layout.simple_spinner_item);
        edades.setAdapter(adapter);

        binding.spEdad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Snackbar.make(view, "Esta app no es para ti", Snackbar.LENGTH_LONG).show();
                        break;
                    case 1:
                        Snackbar.make(view, "Esta app no es para ti", Snackbar.LENGTH_LONG).show();
                        break;
                    case 2:
                        Snackbar.make(view, "Esta app no es para ti", Snackbar.LENGTH_LONG).show();
                        break;
                    case 3:
                        Snackbar.make(view, "Bienvenido a la app", Snackbar.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        binding.tvCondiciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://developers.google.com/ml-kit/terms";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);

                }
                Toast.makeText(MainActivity.this, "no se puede abrir el navegador", Toast.LENGTH_SHORT).show();


            }

        });
    }
    private void abrirCamara(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) !=null){
        takePictureLauncher.launch(takePictureIntent);
        }

    }
    private void verificarCampos(){
        nombre.getText().toString();
        apellido.getText().toString();

    }
    private void validarCaracteres(){
        nombre.getText().toString();
        apellido.getText().toString();
        char[]specialCaracteres = { '!','@','#','$','%','&'};
       /* if (nombre,specialCaracteres)
            nombre.setError("no se permiten caracteres especiales");
        else if (apellido,specialCaracteres)
            apellido.setError("no se permiten caracteres especiales");
        else*/
        Toast.makeText(this,"Registro correcto",Toast.LENGTH_LONG).show();
    }


}