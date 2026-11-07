package com.example.appholamundo

class cotizacionActivity : AppCompatActivity() {
    private lateinit var txtCliente: TextView
    private lateinit var txtFolio: TextView
    private lateinit var txtDescripcion: EditText
    private lateinit var txtPrecio: EditText
    private lateinit var txtPorPag: EditText
    private lateinit var rdb12: RadioButton
    private lateinit var rdb24: RadioButton
    private lateinit var rdb36: RadioButton
    private lateinit var rdb48: RadioButton
    private lateinit var txtPagoInicial: TextView
    private lateinit var txtTotalFin: TextView
    private lateinit var txtPagoMensual: TextView
    private lateinit var btnCalcular: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnCerrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cotizacion)
        iniciarComponentes()
        eventosClic()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun iniciarComponentes() {
        txtCliente = findViewById(R.id.txtCliente) as TextView
        txtFolio = findViewById(R.id.txtFolio) as TextView
        txtDescripcion = findViewById(R.id.txtDescripcion) as EditText
        txtPrecio = findViewById(R.id.txtPrecio) as EditText
        txtPorPag = findViewById(R.id.txtPorcentaje) as EditText
        txtPagoInicial = findViewById(R.id.txtPagoInicial) as TextView
        txtPagoMensual = findViewById(R.id.txtPagoMensual) as TextView
        txtTotalFin = findViewById(R.id.txtTotalFin) as TextView
        rdb12 = findViewById(R.id.rdb12) as RadioButton
        rdb24 = findViewById(R.id.rdb24) as RadioButton
        rdb36 = findViewById(R.id.rdb36) as RadioButton
        rdb48 = findViewById(R.id.rdb48) as RadioButton
        btnCalcular = findViewById(R.id.btnCalcular) as Button
        btnLimpiar = findViewById(R.id.btnLimpiar) as Button
        btnCerrar = findViewById(R.id.btnCerrar) as Button

        var strCliente: String = intent.getStringExtra("cliente").toString()
        txtCliente.text = strCliente

        var folio: Int = abs(Cotizacion().generaFolio())
        txtFolio.text = "Folio : " + folio.toString()
    }

    public fun eventosClic() {
        btnCalcular.setOnClickListener(View.OnClickListener {
            var cotizacion = Cotizacion()
            if (txtDescripcion.text.toString().contentEquals("") ||
                txtPrecio.text.toString().contentEquals("") ||
                txtPorPag.text.toString().contentEquals("")) {
                Toast.makeText(this, "Falto capturar algun dato", Toast.LENGTH_SHORT).show()
            } else {
                txtFolio.text = cotizacion.generaFolio().toString()
                cotizacion.descripcion = txtDescripcion.text.toString()
                cotizacion.precio = txtPrecio.text.toString().toFloat()
                cotizacion.porPagInicial = txtPorPag.text.toString().toFloat()
                if (rdb12.isChecked) cotizacion.plazos = 12
                if (rdb24.isChecked) cotizacion.plazos = 24
                if (rdb36.isChecked) cotizacion.plazos = 36
                if (rdb48.isChecked) cotizacion.plazos = 48
                txtPagoInicial.text = "Pago Inicial " + cotizacion.calcularPagoInicial().toString() + " $"
                txtTotalFin.text = "Total a Financiar " + cotizacion.calcularTotalFin().toString() + " $"
                txtPagoMensual.text = "Pago Mensual " + cotizacion.calcularPagoMensual().toString() + " $"
            }
        })

        btnLimpiar.setOnClickListener(View.OnClickListener {
            txtFolio.text = ""
            txtPagoInicial.text = "Pago Inicial"
            txtTotalFin.text = "Total a Financiar"
            txtPagoMensual.text = "Pago Mensual"
            txtDescripcion.setText("")
            txtPrecio.setText("")
            txtPorPag.setText("")
            rdb12.isChecked = true
        })

        btnCerrar.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
}
