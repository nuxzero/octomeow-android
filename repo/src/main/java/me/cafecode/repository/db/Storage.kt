package me.cafecode.repository.db

import io.realm.Realm
import io.realm.RealmObject
import javax.inject.Inject


class Storage<T : RealmObject> @Inject constructor(val realm: Realm) {

    fun load(id: String, klass: Class<T>): T? =
            realm.where(klass).equalTo("id", id).findFirst()

    fun loadList(klass: Class<T>): List<T> =
            realm.where(klass).findAll().toList()

    fun save(data: T) {
        realm.executeTransaction {
            it.insertOrUpdate(data)
        }
    }

    fun saveList(list: List<T>) {
        realm.executeTransaction { it.insertOrUpdate(list) }
    }

    fun delete(id: String, klass: Class<T>) {
        realm.executeTransaction {
            val data = it.where(klass).equalTo("id", id).findFirst()
            data?.deleteFromRealm()
        }
    }
}
