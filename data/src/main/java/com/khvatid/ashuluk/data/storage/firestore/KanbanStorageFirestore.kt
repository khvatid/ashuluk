package com.khvatid.ashuluk.data.storage.firestore

import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.khvatid.ashuluk.data.storage.KanbanStorage
import com.khvatid.ashuluk.data.storage.models.TaskModel

class KanbanStorageFirestore : KanbanStorage {

    private var listenerRegistration: ListenerRegistration? = null

    override suspend fun addListener(
        userId: String,
        onDocumentEvent: (Boolean, TaskModel) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        val query = Firebase.firestore.collection(TASK_COLLECTION).whereEqualTo(USER_ID, userId)

        listenerRegistration = query.addSnapshotListener { value, error ->
            if (error != null) {
                onError(error)
                return@addSnapshotListener
            }

            value?.documentChanges?.forEach {
                val wasDocumentDeleted = it.type == DocumentChange.Type.REMOVED
                val task = it.document.toObject<TaskModel>().copy(id = it.document.id)
                onDocumentEvent(wasDocumentDeleted, task)
            }

        }


    }

    override suspend fun removeListener() {
        listenerRegistration?.remove()
    }

    override suspend fun getTask(
        taskId: String,
        onError: (Throwable) -> Unit,
        onSuccess: (TaskModel) -> Unit
    ) {
        Firebase.firestore.collection(TASK_COLLECTION).document(taskId).get()
            .addOnFailureListener { error -> onError(error) }
            .addOnSuccessListener { result ->
                val task = result.toObject<TaskModel>()?.copy(id = result.id)
                onSuccess(task ?: TaskModel())
            }
    }

    override suspend fun saveTask(task: TaskModel, onResult: (Throwable?) -> Unit) {
        Firebase.firestore
            .collection(TASK_COLLECTION)
            .add(task)
            .addOnCompleteListener { onResult(it.exception) }
    }

    override suspend fun updateTask(task: TaskModel, onResult: (Throwable?) -> Unit) {
        Firebase.firestore
            .collection(TASK_COLLECTION)
            .document(task.id)
            .set(task)
            .addOnCompleteListener { onResult(it.exception) }
    }

    override suspend fun deleteTask(task: TaskModel, onResult: (Throwable?) -> Unit) {
        Firebase.firestore
            .collection(TASK_COLLECTION)
            .document(task.id)
            .delete()
            .addOnCompleteListener { onResult(it.exception) }
    }

    override suspend fun deleteAllTasks(userId: String, onResult: (Throwable?) -> Unit) {
        TODO("Not yet implemented")
    }

    companion object {
        private const val TASK_COLLECTION = "task"
        private const val USER_ID = "userId"
    }
}