package fes.jonathan.iniciodesesionv1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import fes.jonathan.iniciodesesionv1.activities.MenuActivity;
import fes.jonathan.iniciodesesionv1.models.InicioDeSesionModel;
import fes.jonathan.iniciodesesionv1.models.TokenModel;
import fes.jonathan.iniciodesesionv1.services.SesionService;

public class MainActivity extends AppCompatActivity {
    EditText editTextUsuario;
    EditText editTextContrasena;
    SesionService sesionService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //enlazar los controles con la vista
        editTextUsuario = findViewById(R.id.editTextUsuario);
        editTextContrasena = findViewById(R.id.editTextContrasena);
        sesionService=new SesionService();
    }
    public void iniciarSesion(View view){
        String usuario;
        String contrasena;

        usuario=editTextUsuario.getText().toString();
        contrasena=editTextContrasena.getText().toString();
        if (usuario.equals("john@gmail") && contrasena.equals("123456")){
            Toast.makeText(this,"Bienvenido",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
        }
    }

    public void iniciarSesion2(View view){
        String usuario;
        String contrasena;

        usuario=editTextUsuario.getText().toString();
        contrasena=editTextContrasena.getText().toString();

        TokenModel tokenModel=sesionService.iniciarSesion(new InicioDeSesionModel(usuario,contrasena));
        if (tokenModel==null){
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"Bienvenido",Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(this, MenuActivity.class);
            startActivity(intent);
        }
    }
}