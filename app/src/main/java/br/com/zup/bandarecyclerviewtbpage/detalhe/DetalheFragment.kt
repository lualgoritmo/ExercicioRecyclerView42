package br.com.zup.bandarecyclerviewtbpage.detalhe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.zup.bandarecyclerviewtbpage.databinding.FragmentDetalheBinding
import br.com.zup.bandarecyclerviewtbpage.model.Album
import br.com.zup.constants.CAVALEIRO

class DetalheFragment : Fragment() {
    private lateinit var binding: FragmentDetalheBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalheBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recuperarPersonagemAlbum()
    }

    private fun recuperarPersonagemAlbum() {
        val persongem = arguments?.getParcelable<Album>(CAVALEIRO)
        if (persongem != null) {
            binding.imageViewDetalhe.setImageResource(persongem.img)
            binding.txtViewDetalhe.text = persongem.name
            binding.txtViewDescricao.text = persongem.descricao
        }
    }
}