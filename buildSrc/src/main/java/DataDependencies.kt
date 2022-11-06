object DataDependencies {

    object Room {
        private const val version = "2.4.2"
        const val compiler = "androidx.room:room-ktx:$version"
        const val ktx = "androidx.room:room-runtime:$version"
        const val paging = "androidx.room:room-paging:$version"
    }

    object FireBase {
        const val authenticate = "com.google.firebase:firebase-auth-ktx:21.1.0"
        const val firestore = "com.google.firebase:firebase-firestore-ktx:24.4.0"
    }

    object GoogleService {
        const val playService = "com.google.android.gms:play-services-auth:20.3.0"
    }
}