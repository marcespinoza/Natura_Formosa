package natura.juntoavos.en.formosa.domain.fcm

import android.app.NotificationManager
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import natura.juntoavos.en.formosa.R

class FCMNotificationService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.i("NEW_FCM_TOKEN", token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        showNotification(message)
    }

    private fun showNotification(message: RemoteMessage) {
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val notification = NotificationCompat.Builder(this, "2")
            .setContentTitle(message.notification?.title)
            .setContentText(message.notification?.body)
            //.setSmallIcon(R.drawable.notification_logo)
            .setAutoCancel(true)
            .build()
        notificationManager.notify(1, notification)
    }

}