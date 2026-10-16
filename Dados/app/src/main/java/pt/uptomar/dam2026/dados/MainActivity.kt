package pt.uptomar.dam2026.dados

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import pt.uptomar.dam2026.dados.databinding.ActivityMainBinding
import java.util.Random


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        binding.button.setOnClickListener {
            rollTheDice()
        }

    }

    /**
     * gera número aleatório e mostra o dado associado ao número
     */
    fun rollTheDice() {
        /* Algorithm
         * 1- gerar número aleatório [1,6]
         * 2- usar o número gerado para escolher a imagem
         * 3- mostrar a imagem
         * 4- apresentar número no ecrã
         */

        // 1.
        val diceNumber = Random().nextInt(5) + 1

        // 2.
        val image = when (diceNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // 3.
        binding.diceImage.setImageResource(image)

        // 4.
        binding.diceNumber.text = diceNumber.toString()
    }

}