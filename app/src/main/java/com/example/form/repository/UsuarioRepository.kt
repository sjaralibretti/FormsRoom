package com.example.form.repository

import com.example.form.model.Usuario
import com.example.form.model.UsuarioDao

class UsuarioRepository(private val dao: UsuarioDao) {
    suspend fun obtenerUsuarios(): List<Usuario> = dao.obtenerUsuarios()
    suspend fun insertar(usuario: Usuario) = dao.insertar(usuario)
    suspend fun eliminar(usuario: Usuario) = dao.eliminar(usuario)
}