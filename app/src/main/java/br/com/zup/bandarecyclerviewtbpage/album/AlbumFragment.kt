package br.com.zup.bandarecyclerviewtbpage.album

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import br.com.zup.bandarecyclerviewtbpage.R
import br.com.zup.bandarecyclerviewtbpage.album.adapter.AlbumAdapter
import br.com.zup.bandarecyclerviewtbpage.databinding.FragmentAlbumBinding
import br.com.zup.bandarecyclerviewtbpage.model.Album
import br.com.zup.constants.CAVALEIRO

class AlbumFragment : Fragment() {
    private lateinit var binding: FragmentAlbumBinding

    private val albumAdapter: AlbumAdapter by lazy {
        AlbumAdapter(mutableListOf(), ::onClick)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exibirRecyclerView()
    }

    private fun criarListaCavaleiros() {
        val listaC = mutableListOf<Album>()
        listaC.add(Album(R.drawable.iki, "Iki", "Cavaleiro de Fênix"))
        listaC.add(Album(R.drawable.seya, "Seya", "Cavaleiro de Pegasus"))
        listaC.add(Album(R.drawable.shun, "Shun", "Cavaleiro de Andromeda"))
        listaC.add(Album(R.drawable.yoga, "Yoga", "Cavaleiro de Cisne"))
        listaC.add(Album(R.drawable.shiryu, "Shiryu", "Cavaleiro de Dragão"))
        listaC.add(
            Album(
                R.drawable.cavaleirosdozodiaco,
                "Cavaleiros",
                "Todos os Cavaleiros juntos"
            )
        )
        if (listaC != null) {
            albumAdapter.atualizarListaAlbum(listaC)
        }
    }

    private fun exibirRecyclerView() {
        binding.rvRecyclerAlbum.adapter = albumAdapter
        binding.rvRecyclerAlbum.layoutManager = GridLayoutManager(context, 2)
    }

    private fun onClick(album: Album) {
        val bundle = bundleOf(CAVALEIRO to album)
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_albumFragment_to_detalheFragment, bundle)
//        Toast.makeText(context, "Teste${album.name}", Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        criarListaCavaleiros()
    }
//    private fun criarListaDeCavalheiros() {
//        val listaAlbum = mutableListOf<Album>()
//        listaAlbum.add(
//            Album(R.drawable.seya, "Seya", "Cavaleiro de ouro de Sagitário")
//        )
//        listaAlbum.add(Album(R.drawable.yoga, "Yoga", "Cavaleiro de Cisne"))
//        listaAlbum.add(Album(R.drawable.shiryu, name = "Shiryu", "Cavaleiro de Dragão"))
//        listaAlbum.add(Album(R.drawable.iki, name = "Ikki", "Cavaleiro de Fênix"))
//    }
    //RECEBENDO LISTA
//    private fun receberLista(): MutableList<Album> {
//        val listaAlbum = mutableListOf<Album>()
//        listaAlbum.add(
//            Album(R.drawable.iki, "Desenho", "Não sei")
//        )
//        listaAlbum.add(Album(R.drawable.seya, "Mariooooafa", "Criatividade zero"))
//        return listaAlbum
//    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
////        binding.recyclerAlbum.adapter = albumAdapter
////        binding.recyclerAlbum.layoutManager = LinearLayoutManager(context)
////        binding.recyclerAlbum.adapter = AlbumAdapter(receberL())
////        binding.recyclerAlbum.layoutManager = LinearLayoutManager(context)
//    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
////        receberLista()
//    }

}