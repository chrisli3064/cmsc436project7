package com.example.project7
//Joseph Yi, Christopher Li, Mudit Mathur, Bhargav Tumkur
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Toast
import android.widget.Toast.makeText
import java.io.InputStream
import javax.xml.parsers.SAXParser
import javax.xml.parsers.SAXParserFactory
class MainActivity : AppCompatActivity() {

    private lateinit var gameView: GameView
    private lateinit var balloons: Balloons
    private var endToastShown : Boolean = false



    private lateinit var detector : GestureDetector
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory : SAXParserFactory = SAXParserFactory.newInstance()
        val saxParser : SAXParser = factory.newSAXParser()

        val handler: SAXHandler = SAXHandler()
        val BALLOONID = R.raw.balloons3
        var iStream : InputStream = resources.openRawResource(BALLOONID)

        val width : Int  = resources.displayMetrics.widthPixels
        val height : Int = resources.displayMetrics.heightPixels
        val statusBarHeightId : Int =
            resources.getIdentifier( "status_bar_height", "dimen", "android" )
        val statusBarHeight : Int = resources.getDimensionPixelSize( statusBarHeightId )

        saxParser.parse(iStream, handler)

        val balloonList: ArrayList<Balloon> = handler.getItems()
        for (balloon in balloonList)
            Log.w( "MainActivity", balloon.toString() )

        gameView = GameView(this, statusBarHeight, width, height, balloonList )

        setContentView(gameView)

        balloons = gameView.getBalloons()

        var th: TouchHandler = TouchHandler()
        detector = GestureDetector(this,th)

    }
    override fun onTouchEvent( event: MotionEvent?):Boolean{
        if (event != null){
            detector.onTouchEvent(event)
        }

        return super.onTouchEvent(event)

    }

    inner class TouchHandler : GestureDetector.SimpleOnGestureListener() {

        override fun onSingleTapConfirmed(e: MotionEvent): Boolean {

            var winCheck = balloons.onClick(e.x,e.y)
            gameView.postInvalidate()

            if (winCheck == 1 && !endToastShown) {
                var toast : Toast = makeText(this@MainActivity, "YOU WON", Toast.LENGTH_LONG)
                toast.show()
                endToastShown = true
            } else if (winCheck == -1 && !endToastShown) {
                finish()
            }

            return super.onSingleTapConfirmed(e)
        }

    }

}