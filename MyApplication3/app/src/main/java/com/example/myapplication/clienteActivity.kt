package com.example.appholamundo

class clienteActivity : AppCompatActivity() {
    private lateinit var txtCliente: EditText
    private lateinit var btnIngresar: Button
    private lateinit var btnRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cliente)
        iniciarComponentes()
        eventosClic()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    public fun iniciarComponentes() {
        txtCliente = findViewById(R.id.txtCliente) as EditText
        btnRegresar = findViewById(R.id.btnRegresar) as Button
        btnIngresar = findViewById(R.id.btnEntrar) as Button
    }

    public fun eventosClic() {
        btnIngresar.setOnClickListener(View.OnClickListener {
            if (txtCliente.text.toString().contentEquals("")) {
                Toast.makeText(this, "Falto capturar el nombre del cliente", Toast.LENGTH_SHORT).show()
                txtCliente.requestFocus()
            } else {
                val intent = Intent(this, cotizacionActivity::class.java)
                intent.putExtra("cliente", txtCliente.text.toString())
                startActivity(intent)
            }
        })

        btnRegresar.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
}
