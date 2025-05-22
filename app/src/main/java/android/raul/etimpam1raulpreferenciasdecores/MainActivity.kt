package android.raul.etimpam1raulpreferenciasdecores

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.raul.etimpam1raulpreferenciasdecores.databinding.ActivityMainBinding
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var preferencias:SharedPreferences

    companion object{
        const val NOME_ARQUIVO = "arquivo_prefs.xml"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        var cor = ""
        binding.btnCor1.setOnClickListener {
            cor = "#C20EE4"
            salvarCor(cor)
        }

        binding.btnCor2.setOnClickListener {
            cor = "#FFEB3B"
            salvarCor(cor)
        }

        binding.btnCor3.setOnClickListener {
            cor = "#FF5722"
            salvarCor(cor)
        }

        binding.btnCor4.setOnClickListener {
            cor = "#03A9F4"
            salvarCor(cor)

        }

        binding.btnCor5.setOnClickListener {
            cor = "#BC6F06"
            salvarCor(cor)

        }


    }

    override fun onResume() {
        super.onResume()

        val preferencias = getSharedPreferences(NOME_ARQUIVO, MODE_PRIVATE)
        val cor = preferencias.getString("cor", "")

        if(cor!!.isNotEmpty()){
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
        }
    }

    private fun salvarCor(cor: String) {
        binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))

        binding.btnTrocar.setOnClickListener {view ->
            val preferencias = getSharedPreferences(NOME_ARQUIVO, MODE_PRIVATE)
            val editor = preferencias.edit()
            editor.putString("cor", cor)
            editor.putString("nome", "Raul")
            editor.putString("sobrenome", "Luis")
            editor.putInt("Idade", 16)
            editor.apply()

            snackBar(view)
        }


        }

        private fun snackBar(view:View){
            val snackbar = Snackbar.make(view, "Cor de fundo alterada com sucesso", Snackbar.LENGTH_INDEFINITE)
            snackbar.setAction("OK"){

            }

            snackbar.setActionTextColor(Color.YELLOW)
            snackbar.setBackgroundTint(Color.BLUE)
            snackbar.setTextColor(Color.RED)
            snackbar.show()
        }
}


