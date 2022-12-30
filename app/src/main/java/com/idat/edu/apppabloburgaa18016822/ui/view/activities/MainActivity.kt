package com.idat.edu.apppabloburgaa18016822.ui.view.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.idat.edu.apppabloburgaa18016822.R
import com.idat.edu.apppabloburgaa18016822.core.helpers.MessageHelper
import com.idat.edu.apppabloburgaa18016822.data.Paciente
import com.idat.edu.apppabloburgaa18016822.data.database.model.PacienteEntity
import com.idat.edu.apppabloburgaa18016822.databinding.ActivityMainBinding
import com.idat.edu.apppabloburgaa18016822.ui.viewmodel.PacienteViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pacientes: List<Paciente>
    private val pacienteViewModel: PacienteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pacientes = getPacientes()
        pacienteViewModel.onCreate(this)

        binding.bntLogin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.bntLogin -> login()
        }
    }

    private fun login() {
        val codigo = binding.tvCodPaciente.text.toString()
        val password = binding.tvPassword.text.toString()

        val response =
            pacientes.filter { paciente -> paciente.codpaciente == codigo && paciente.password == password }

        if (response.isNotEmpty()) {
            //Guardar con ROOM
            pacienteViewModel.insertPaciente(PacienteEntity(password = response[0].password,
                nombreapellido = response[0].nombreapellido,
                celular = response[0].celular))
            startActivity(Intent(this, HomeActivity::class.java))
        } else MessageHelper.sendMessage(binding.root, "Usuario y/o contrasenia incorrecto...")
    }

    private fun getPacientes(): List<Paciente> =
        listOf(Paciente("P938476201", "password", "Pablo Burga", "938476201"),
            Paciente("P902189274", "password", "Luis Salvatierra", "902189274"),
            Paciente("P989738457", "password", "Maria Diaz", "989738457"))
}