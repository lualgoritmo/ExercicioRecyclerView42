package br.com.zup.bandarecyclerviewtbpage.album.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.bandarecyclerviewtbpage.databinding.AlbumItemBinding
import br.com.zup.bandarecyclerviewtbpage.model.Album

class AlbumAdapter(
    var listaAlbum: MutableList<Album>,
    private val onClick: (album: Album) -> Unit
) : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AlbumItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemAlbum = listaAlbum[position]
        holder.exibirInformacoes(itemAlbum)
        holder.binding.itemCavaleiro.setOnClickListener {
            onClick(itemAlbum)
        }
    }

    override fun getItemCount() = listaAlbum.size

    fun atualizarListaAlbum(novaListaAlbum: MutableList<Album>) {
        if (listaAlbum.size == 0) {
            listaAlbum = novaListaAlbum
        } else {
            listaAlbum.addAll(novaListaAlbum)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: AlbumItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun exibirInformacoes(album: Album) {
            binding.ivAlbum.setImageResource(album.img)
            binding.tvNomeAlbum.text = album.name
        }
    }
}