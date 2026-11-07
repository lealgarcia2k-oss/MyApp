package com.example.appholamundo

class menuActivity : AppCompatActivity() {
    private lateinit var crvHola : CardView
    private lateinit var crvImc : CardView
    private lateinit var crvGrados : CardView
    private lateinit var crvMoneda : CardView
    private lateinit var crvCotizacion : CardView
    private lateinit var crvSpinner : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        iniciarComponentes()
        eventosClic()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun iniciarComponentes() {
        crvHola = findViewById(R.id.crvHola) as CardView
        crvImc = findViewById(R.id.crvImc) as CardView
        crvGrados = findViewById(R.id.crvConvertir) as CardView
        crvMoneda = findViewById(R.id.crvMonedas) as CardView
        crvCotizacion = findViewById(R.id.crvCotizacion) as CardView
        crvSpinner = findViewById(R.id.crvSpinner) as CardView
    }

    fun eventosClic() {
        crvHola.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
    }
}
