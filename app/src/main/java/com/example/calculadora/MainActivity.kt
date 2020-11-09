package com.example.calculadora

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    var punto = false;
    var negativo = false;
    var isNewOp = false;
    var oldNumber = ""
    var op = "+"
    var newnumberH = "0"
    var cambioNegativoPositivo = "+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        editText1.setText("0")
    }

    //VERTICAL
    fun numberEvent(view: View) {
        try {
            var buclick = editText1.text.toString()
            var buselect = view as Button;

            if (buclick.equals("0")) {
                buclick = ""
            }


            when (buselect.id) {
                bu1.id -> {
                    buclick += "1"
                    buBin.setEnabled(true)
                }
                bu2.id -> {
                    buclick += "2"
                    buBin.setEnabled(true)
                }
                bu3.id -> {
                    buclick += "3"
                    buBin.setEnabled(true)
                }
                bu4.id -> {
                    buclick += "4"
                    buBin.setEnabled(true)
                }
                bu5.id -> {
                    buclick += "5"
                    buBin.setEnabled(true)
                }
                bu6.id -> {
                    buclick += "6"
                    buBin.setEnabled(true)
                }
                bu7.id -> {
                    buclick += "7"
                    buBin.setEnabled(true)
                }
                bu8.id -> {
                    buclick += "8"
                    buBin.setEnabled(true)
                }
                bu9.id -> {
                    buclick += "9"
                    buBin.setEnabled(true)
                }
                bu0.id -> {
                    buclick += "0"
                }
                buDot.id -> {
                    if (!punto) {
                        if (buclick.isEmpty()) {
                            buclick += "0."
                            punto = true;
                        } else {
                            buclick += "."
                            punto = true

                        }
                        buDot.setEnabled(false)
                    }
                }
                buBin.id -> {

                    if (cambioNegativoPositivo == "+") {
                        buclick = "-$buclick"
                        cambioNegativoPositivo = "-";

                    } else {
                        buclick = buclick.substring(1, buclick.length);
                        cambioNegativoPositivo = "+";
                    }
                }

            }
            editText1.setText(buclick)
        } catch (e: StringIndexOutOfBoundsException) {
        }
    }


    fun operatorEvent(view: View) {
        isNewOp = true
        oldNumber = editText1.text.toString()
        editText1.setText("0")

        var buselect = view as Button
        when (buselect.id) {
            bHex.id -> {
                op = "*"
            }
            buPLus.id -> {
                op = "+"
            }
            buMinus.id -> {
                op = "-"
            }
            bDec.id -> {
                op = "/"
            }
        }

    }

    fun equalEvent(view: View) {
        try {
            var newnumber = editText1.text.toString()
            var result = 0.0
            when (op) {
                "+" -> {
                    result = oldNumber.toDouble() + newnumber.toDouble()
                }
                "*" -> {
                    result = oldNumber.toDouble() * newnumber.toDouble()
                }
                "/" -> {
                    result = oldNumber.toDouble() / newnumber.toDouble()
                }
                "-" -> {
                    result = oldNumber.toDouble() - newnumber.toDouble()
                }
            }
            if (result.isNaN() || result.isInfinite()) {
                Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show()
                editText1.setText("0")
            } else {
                editText1.setText(result.toString())
            }
        } catch (e: Exception) {
        }
    }

    fun acEvent(view: View) {
        editText1.setText("0")
        buBin.setEnabled(false)
        buDot.setEnabled(true)
        punto = false

    }

    //HORIZONTAL
    fun numberEventHorizontal(view: View) {
        var buclick = editText1.text.toString()
        var buselect = view as Button;
        if (buclick.equals("0")) {
            buclick = ""
        }

        when (buselect.id) {
            bu1.id -> {
                buclick += "1"
            }
            bu2.id -> {
                buclick += "2"
            }
            bu3.id -> {
                buclick += "3"
            }
            bu4.id -> {
                buclick += "4"
            }
            bu5.id -> {
                buclick += "5"
            }
            bu6.id -> {
                buclick += "6"
            }
            bu7.id -> {
                buclick += "7"
            }
            bu8.id -> {
                buclick += "8"
            }
            bu9.id -> {
                buclick += "9"
            }
            bu0.id -> {
                buclick += "0"
            }
            buttonA.id -> {
                buclick += "a"
            }
            buttonB.id -> {
                buclick += "b"
            }
            buttonC.id -> {
                buclick += "c"
            }
            buttonD.id -> {
                buclick += "d"
            }
            buttonE.id -> {
                buclick += "e"
            }
            buttonF.id -> {
                buclick += "f"
            }
        }
        editText1.setText(buclick)
    }


    fun operatorEventHorizontal(view: View) {
        isNewOp = true
        if (!buttonBinario.isEnabled) {
            var numero = editText1.text.toString().toLong()
            var a = convertBinaryToDecimal(numero)
            oldNumber = a.toString()
            editText1.setText("0")
        }
        if (!buttonHexadecimal.isEnabled) {
            var x = hexadecimalADecimal(editText1.text.toString());
            oldNumber = x.toString()
            editText1.setText("0")
        }
        if (!buttonDecimal.isEnabled) {
            oldNumber = editText1.text.toString()
            editText1.setText("0")
        }


        var buselect = view as Button
        when (buselect.id) {
            bHex.id -> {
                op = "*"
            }
            buPLus.id -> {
                op = "+"
            }
            buMinus.id -> {
                op = "-"
            }
            bDec.id -> {
                op = "/"
            }
        }
    }

    fun equalEventHorizontal(view: View) {
        var actual = editText1.text.toString()
        try {
            var result = 0


            if (!buttonBinario.isEnabled) {
                var numero = editText1.text.toString().toLong()
                var x = convertBinaryToDecimal(numero)
                newnumberH = x.toString()
            }
            if (!buttonHexadecimal.isEnabled) {
                var x = hexadecimalADecimal(editText1.text.toString());
                newnumberH = x.toString()
            }
            if (!buttonDecimal.isEnabled) {
                newnumberH = editText1.text.toString()
            }
            when (op) {
                "+" -> {
                    result = oldNumber.toInt() + newnumberH.toInt()
                }
                "*" -> {
                    result = oldNumber.toInt() * newnumberH.toInt()
                }
                "/" -> {
                    result = oldNumber.toInt() / newnumberH.toInt()
                }
                "-" -> {
                    result = oldNumber.toInt() - newnumberH.toInt()
                }
            }

            if (!buttonBinario.isEnabled) {
                var bin = result.toString()

                //var x = convertBinaryToDecimal(bin)
                var resBin = Integer.toBinaryString(bin.toInt())
                editText1.setText(resBin.toString())
            }
            if (!buttonHexadecimal.isEnabled) {
                var e = result.toString()
                var r = Integer.toHexString(e.toInt())
                editText1.setText(r)
            }
            if (!buttonDecimal.isEnabled) {
                editText1.setText(result.toString())
            }
        } catch (ae: ArithmeticException) {
            Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show();
            editText1.setText("0")
        } catch (ne: NumberFormatException) {
            editText1.setText(actual)
        } catch (e: Exception) {
            Toast.makeText(this, "Numero demasiado grande ", Toast.LENGTH_SHORT).show();
            editText1.setText("0")
        }
    }

    fun modoCalculadora(view: View, numero: Int) {
        if (numero == 0) {
            bu2.setEnabled(false)
            bu3.setEnabled(false)
            bu4.setEnabled(false)
            bu5.setEnabled(false)
            bu6.setEnabled(false)
            bu7.setEnabled(false)
            bu8.setEnabled(false)
            bu9.setEnabled(false)

            if (!buttonHexadecimal.isEnabled) {
                buttonA.setEnabled(false)
                buttonB.setEnabled(false)
                buttonC.setEnabled(false)
                buttonD.setEnabled(false)
                buttonE.setEnabled(false)
                buttonF.setEnabled(false)

            }
        } else if (numero == 1) {
            if (!buttonBinario.isEnabled) {
                bu2.setEnabled(true)
                bu3.setEnabled(true)
                bu4.setEnabled(true)
                bu5.setEnabled(true)
                bu6.setEnabled(true)
                bu7.setEnabled(true)
                bu8.setEnabled(true)
                bu9.setEnabled(true)
            } else {
                buttonA.setEnabled(false)
                buttonB.setEnabled(false)
                buttonC.setEnabled(false)
                buttonD.setEnabled(false)
                buttonE.setEnabled(false)
                buttonF.setEnabled(false)
            }
        } else {
            buttonA.setEnabled(true)
            buttonB.setEnabled(true)
            buttonC.setEnabled(true)
            buttonD.setEnabled(true)
            buttonE.setEnabled(true)
            buttonF.setEnabled(true)
            if (!buttonBinario.isEnabled) {
                bu2.setEnabled(true)
                bu3.setEnabled(true)
                bu4.setEnabled(true)
                bu5.setEnabled(true)
                bu6.setEnabled(true)
                bu7.setEnabled(true)
                bu8.setEnabled(true)
                bu9.setEnabled(true)
            }
        }


    }


    fun convertBinaryToDecimal(num: Long): Int {
        var num = num
        var decimalNumber = 0
        var i = 0
        var remainder: Long

        while (num.toInt() != 0) {
            remainder = num % 10
            num /= 10
            decimalNumber += (remainder * Math.pow(2.0, i.toDouble())).toInt()
            ++i
        }
        return decimalNumber
    }

    fun caracterHexadecimalADecimal(caracter: Char): Int {
        return when (caracter) {
            'a' -> 10
            'b' -> 11
            'c' -> 12
            'd' -> 13
            'e' -> 14
            'f' -> 15
            else -> caracter.toString().toInt()
        }
    }

    fun hexadecimalADecimal(hexadecimal: String): Long {
        var decimal: Long = 0
        // Saber en cuál posición de la cadena (de izquierda a derecha) vamos
        var potencia = 0
        // Recorrer la cadena de derecha a izquierda
        for (x in hexadecimal.length - 1 downTo 0) {
            val valor = caracterHexadecimalADecimal(hexadecimal[x])
            val elevado = Math.pow(16.0, potencia.toDouble()).toLong() * valor
            decimal += elevado
            // Avanzar en la potencia
            potencia++
        }
        return decimal
    }

    fun bHexadecimal(view: View) {
        try {
            if (!buttonBinario.isEnabled) {
                var numero = editText1.text.toString().toLong()
                var a = convertBinaryToDecimal(numero)
                editText1.setText(Integer.toHexString(a))
            }
            if (!buttonDecimal.isEnabled) {
                editText1.setText(Integer.toHexString(editText1.text.toString().toInt()))
            }
            modoCalculadora(view, 2);
            buttonBinario.setEnabled(true);
            buttonDecimal.setEnabled(true);
            buttonHexadecimal.setEnabled(false);
        } catch (e: Exception) {
            Toast.makeText(this, "Numero demasiado grande ", Toast.LENGTH_SHORT).show();
            editText1.setText("0")
        }

    }


    fun bDecimal(view: View) {
        try {
            if (!buttonBinario.isEnabled) {
                var numero = editText1.text.toString().toLong()
                var a = convertBinaryToDecimal(numero)
                editText1.setText(a.toString())
            }
            if (!buttonHexadecimal.isEnabled) {
                var x = hexadecimalADecimal(editText1.text.toString());
                editText1.setText("" + x)
            }
            modoCalculadora(view, 1)
            buttonBinario.setEnabled(true);
            buttonDecimal.setEnabled(false);
            buttonHexadecimal.setEnabled(true);
        } catch (e: Exception) {
            Toast.makeText(this, "Numero demasiado grande ", Toast.LENGTH_SHORT).show();
            editText1.setText("0")
        }
    }

    fun Binario(view: View) {
        try {
            if (!buttonDecimal.isEnabled) {
                var a = editText1.text.toString().toInt()
                editText1.setText(Integer.toBinaryString(a))
            }
            if (!buttonHexadecimal.isEnabled) {
                var x = hexadecimalADecimal(editText1.text.toString());
                editText1.setText(Integer.toBinaryString(x.toInt()))
            }

            modoCalculadora(view, 0);
            buttonBinario.setEnabled(false);
            buttonDecimal.setEnabled(true);
            buttonHexadecimal.setEnabled(true);
        } catch (e: Exception) {
            Toast.makeText(this, "Numero demasiado grande", Toast.LENGTH_SHORT).show();
            editText1.setText("0")
        }
    }

    fun acEventHorizontal(view: View) {
        editText1.setText("0")
    }
}