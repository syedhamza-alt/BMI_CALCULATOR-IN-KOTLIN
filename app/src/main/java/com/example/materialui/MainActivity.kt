package com.example.materialui

import DatabaseBuilder
import android.R
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.materialui.databinding.ActivityMainBinding
import com.example.materialui.room.AppDatabase
import com.example.materialui.room.BMI
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.DoubleBounce


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        database = DatabaseBuilder.getInstance(this)

        binding.calculateBTN.setOnClickListener {

                val weightStr = binding.weightEt.editText?.text?.toString()
            val heightStr = binding.heightEt.editText?.text?.toString()
            val name = "Hamza";
            if (weightStr.isNullOrBlank() || heightStr.isNullOrBlank()) {
                Toast.makeText(applicationContext, "Input is empty", Toast.LENGTH_SHORT).show()
            } else {
                try{
                    binding.spinKit.visibility=View.VISIBLE;


                    val weight = weightStr.toDouble()
                    val height = heightStr.toDouble()

                    val bmi = 703 * (weight / (height * height))

                    val bmiMessage = "BMI: $bmi"

                    when {

                        bmi < 18.5 -> {
                            Toast.makeText(
                                applicationContext,
                                "$bmiMessage\nUnderweight",
                                Toast.LENGTH_SHORT
                            ).show()
                            val obj3 = BMI(name = name, height = height, weight = weight)
                            database.userDao().insertLogin(obj3)

                        }

                        bmi.toDouble() in 18.5..24.9 -> {
                            Toast.makeText(
                                applicationContext,
                                "$bmiMessage\nNormal Weight",
                                Toast.LENGTH_SHORT
                            ).show()
                            val obj3 = BMI(name = name, height = height, weight = weight)
                            database.userDao().insertLogin(obj3)

                        }

                        bmi.toDouble() in 25.0..29.9 -> {
                            Toast.makeText(
                                applicationContext,
                                "$bmiMessage\nOverweight",
                                Toast.LENGTH_SHORT
                            ).show()
                            val obj3 = BMI(name = name, height = height, weight = weight)
                            database.userDao().insertLogin(obj3)

                        }

                        bmi >= 30 -> {
                            Toast.makeText(
                                applicationContext,
                                "$bmiMessage\nObesity",
                                Toast.LENGTH_SHORT
                            ).show()
                            val obj3 = BMI(name = name, height = height, weight = weight)
                            database.userDao().insertLogin(obj3)

                        }

                    }
                } catch (e: NumberFormatException) {
                    Toast.makeText(applicationContext, "Invalid Input", Toast.LENGTH_SHORT).show()
                }   catch (e: android.database.sqlite.SQLiteConstraintException) {
                    // Handle unique constraint violation (duplicate name)
                    Toast.makeText(applicationContext, "Name already exists", Toast.LENGTH_SHORT).show()
                } finally {
                    binding.spinKit.visibility = View.INVISIBLE
                }
            }
        }


//        val weightStr=binding.weightEt.editText?.text.toString();
//        val heightStr= binding.heightEt.editText?.text.toString();
//        if (weightStr.isNotEmpty() && heightStr.isNotEmpty()){
//        val weight=weightStr.toInt();
//        val height=heightStr.toInt();
//        binding.calculateBTN.setOnClickListener{
//            if (weight != null && height != null) {
//
//                val bmi=703*(weight/(height*height));
//                if(bmi <18.5){
//                    Toast.makeText(applicationContext,"BMI : $bmi", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(applicationContext,"Underweight", Toast.LENGTH_SHORT).show();
//                    val obj3=BMI(height =height, weight = weight);
//                    database.userDao().insertLogin(obj3);
//                } else if(bmi >= 18.9 && bmi <=24.9){
//                    Toast.makeText(applicationContext,"BMI : $bmi", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(applicationContext,"Noraml Weight", Toast.LENGTH_SHORT).show();
//                    val obj3=BMI(height =height, weight = weight);
//                    database.userDao().insertLogin(obj3);
//                } else if(bmi >= 25 && bmi <=29.9){
//                    Toast.makeText(applicationContext,"BMI : $bmi", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(applicationContext,"Overweight", Toast.LENGTH_SHORT).show();
//                    val obj3=BMI(height =height, weight = weight);
//                    database.userDao().insertLogin(obj3);
//                } else if(bmi >=30){
//                    Toast.makeText(applicationContext,"BMI : $bmi", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(applicationContext,"Obesity", Toast.LENGTH_SHORT).show();
//                    val obj3=BMI(height =height, weight = weight);
//                    database.userDao().insertLogin(obj3);
//                }
//            } else{
//                Toast.makeText(applicationContext," Invalid Input", Toast.LENGTH_SHORT).show();
//            }
//
//            }
//        } else{
//        Toast.makeText(applicationContext," Input is empty", Toast.LENGTH_SHORT).show();
//
//    }
    }
}
