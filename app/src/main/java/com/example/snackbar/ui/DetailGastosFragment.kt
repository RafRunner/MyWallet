package com.example.snackbar.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.snackbar.R
import com.example.snackbar.domain.Gasto
import kotlinx.android.synthetic.main.fragment_detail_gastos.view.*
import java.util.*

class DetailGastosFragment : Fragment() {
    private var titulo = ""

    private var listGastos = getListGastos()
    private val adapter = DetailGastosAdapter(listGastos)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_detail_gastos, container, false)
        view.tvTituloGastos.text = titulo

        view.rcListaEntradas.adapter = adapter
        view.rcListaEntradas.layoutManager = LinearLayoutManager(context)
        view.rcListaEntradas.setHasFixedSize(true)

        view.btnAdicionaGasto.setOnClickListener {
            insertGasto(Gasto("Gasto dinâmico", "Dinâmico", Date().toString(), 0.00))
        }

        view.btnRemoveGasto.setOnClickListener {
            removeGasto()
        }

        return view
    }

    // Gastos estáticos temporários
    fun getListGastos(): MutableList<Gasto> = mutableListOf(
        Gasto("Padaria", "Alimentação", "2020/10/21 9:35:10", 7.50),
        Gasto("Papelaria", "Materiais", "2020/10/19 14:37:17", 54.32)
    )

    fun insertGasto(gasto: Gasto) {
        listGastos.add(gasto)
        adapter.notifyItemInserted(adapter.itemCount)
    }

    fun removeGasto() {
        if (adapter.itemCount == 0) return
        listGastos.removeAt(adapter.itemCount - 1)
        adapter.notifyItemRemoved(adapter.itemCount)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.getString("titulo")?.let {
            titulo = it
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(titulo: String) = DetailGastosFragment().apply {
            arguments = Bundle().apply {
                putString("titulo", titulo)
            }
        }
    }
}