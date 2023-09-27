import android.R
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.graphics.PixelFormat
import android.os.Build
import android.os.IBinder
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.WindowManager
import android.widget.Button

class OverlayService : Service() {
    private var windowManager: WindowManager? = null
    private var overlay: View? = null
    private var overlayButton: Button? = null
    private var initialX = 0
    private var initialY = 0
    private var initialTouchX = 0f
    private var initialTouchY = 0f
    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        windowManager = getSystemService(WINDOW_SERVICE) as WindowManager
        val inflater = LayoutInflater.from(this)
        overlay = inflater.inflate(R.layout.activity_overlaychip, null)
        overlayButton = overlay!!.findViewById<Button>(R.id.overlayButton)
        val layoutParams = WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY else WindowManager.LayoutParams.TYPE_PHONE,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            PixelFormat.TRANSLUCENT
        )
        layoutParams.gravity = Gravity.TOP or Gravity.START
        layoutParams.x = 0
        layoutParams.y = 100 // Adjust Y position as needed
        overlayButton?.setOnClickListener {
            val packageName = "com.example.annotation"
            val activityName = "com.example.annotation.MainActivity"
            val intent = Intent()
            intent.setClassName(packageName, activityName)
            intent.flags =
                Intent.FLAG_ACTIVITY_NEW_TASK // Add this flag to start the activity in a new task
            val appContext =
                applicationContext // The context of your overlay view
            appContext.startActivity(intent)
            // Handle button click action here
        }

        overlay?.setOnTouchListener(OnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_MOVE -> {
                    val xOffsett = (event.rawX - initialTouchX).toInt()
                    val yOffsett = (event.rawY - initialTouchY).toInt()
                    layoutParams.x = initialX + xOffsett
                    layoutParams.y = initialY + yOffsett
                    windowManager!!.updateViewLayout(overlay, layoutParams)
                    return@OnTouchListener true
                }

                MotionEvent.ACTION_DOWN -> {
                    initialX = layoutParams.x
                    initialY = layoutParams.y
                    initialTouchX = event.rawX
                    initialTouchY = event.rawY
                    return@OnTouchListener true
                }
            }
            false
        })
        windowManager!!.addView(overlay, layoutParams)


        // Create the notification and start the service as foreground
        val channelId = "overlay_channel_id"
        val notification = createNotification()
        startForeground(NOTIFICATION_ID, notification)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (overlay != null) {
            windowManager!!.removeView(overlay)
        }
    }

    private fun createNotification(): Notification {
        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            notificationIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        val builder: Notification.Builder = Notification.Builder(this)
            .setContentTitle("Overlay Button Service")
            .setContentText("Click to open the app.")
            .setSmallIcon(R.drawable.ic_notification_icon)
            .setContentIntent(pendingIntent)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "overlay_channel_id"
            val channel = NotificationChannel(
                channelId,
                "Overlay Channel",
                NotificationManager.IMPORTANCE_LOW
            )
            getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
            builder.setChannelId(channelId)
        }
        return builder.build()
    }

    companion object {
        private const val NOTIFICATION_ID = 123
    }
}