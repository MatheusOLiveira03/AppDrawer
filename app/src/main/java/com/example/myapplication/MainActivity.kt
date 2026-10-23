package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val menu = findViewById<NavigationView>(R.id.navigationView)
        val texto = findViewById<TextView>(R.id.txtConteudo)

        ViewCompat.setOnApplyWindowInsetsListener(drawer) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            
            toolbar.setPadding(0, systemBars.top, 0, 0)
            
            menu.setPadding(0, systemBars.top, 0, 0)
            
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)

            insets
        }

        toolbar.setNavigationOnClickListener {
            drawer.openDrawer(GravityCompat.START)
        }

        menu.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_inicio -> {
                    texto.text = "Tela inicial"
                }
                R.id.menu_perfil -> {
                    texto.text = "Meu perfil"
                }
                R.id.menu_config -> {
                    texto.text = "Configurações"
                }
            }
            drawer.closeDrawer(GravityCompat.START)
            true
        }
    }
}
