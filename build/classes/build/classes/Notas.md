## Cosas a mejorar:
Hacer un padre jdbc donde crear un metodo consulta() para llamarlo directamente desde cualquier dao ej obtenet todos(){consulta()} y asi no escribimos tanto codigo

en el de javi: public Iterable<T> consula(String sql, Object... datos).......

en resumen, hacer otros metodos para evitar tener que crear cada crud dentro de un nuevo dao.
Mirar tamben el archivo fabrica, para conseguir hacer algo general

Hacer mis propias excepciones, dividirlas por capas