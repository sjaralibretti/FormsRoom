package com.example.form.model

import androidx.room.*

@Dao
interface UsuarioDao {
    @Query("SELECT * FROM usuarios ORDER BY id DESC")
    suspend fun obtenerUsuarios(): List<Usuario>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(usuario: Usuario)

    @Delete
    suspend fun eliminar(usuario: Usuario)
}
