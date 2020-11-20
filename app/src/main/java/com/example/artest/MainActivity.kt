package com.example.artest

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.ViewCompat.setBackground
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.math.Vector3
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.rendering.ViewRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var arrayView: Array<View>

    lateinit var bearRenderable: ModelRenderable
    lateinit var catRenderable: ModelRenderable
    lateinit var cowRenderable: ModelRenderable
    lateinit var dogRenderable: ModelRenderable
    lateinit var elephantRenderable: ModelRenderable
    lateinit var ferretRenderable: ModelRenderable
    lateinit var hippoRenderable: ModelRenderable
    lateinit var horseRenderable: ModelRenderable
    lateinit var koalaRenderable: ModelRenderable
    lateinit var lionRenderable: ModelRenderable
    lateinit var reindeerRenderable: ModelRenderable
    lateinit var wolverineRenderable: ModelRenderable

    internal var selected = 1 //Default 1 is choose bear

    lateinit var arFragment:ArFragment

    override fun onClick(view: View?) {
        if(view!!.id == R.id.img_bear) {
            selected = 1
            mySetBackground(view!!.id)
        } else if(view!!.id == R.id.img_cat) {
            selected = 2
            mySetBackground(view!!.id)
        } else if(view!!.id == R.id.img_cow) {
            selected = 3
            mySetBackground(view!!.id)
        } else if(view!!.id == R.id.img_dog) {
            selected = 4
            mySetBackground(view!!.id)
        } else if(view!!.id == R.id.img_elephant) {
            selected = 5
            mySetBackground(view!!.id)
        } else if(view!!.id == R.id.img_ferret) {
            selected = 6
            mySetBackground(view!!.id)
        } else if(view!!.id == R.id.img_hippo) {
            selected = 7
            mySetBackground(view!!.id)
        } else if(view!!.id == R.id.img_horse) {
            selected = 8
            mySetBackground(view!!.id)
        } else if(view!!.id == R.id.img_koala) {
            selected = 9
            mySetBackground(view!!.id)
        } else if(view!!.id == R.id.img_lion) {
            selected = 10
            mySetBackground(view!!.id)
        } else if(view!!.id == R.id.img_reindeer) {
            selected = 11
            mySetBackground(view!!.id)
        } else if(view!!.id == R.id.img_wolverine) {
            selected = 12
            mySetBackground(view!!.id)
        }
    }

    private fun mySetBackground(id: Int) {
        for(i in arrayView.indices) {
            if(arrayView[i].id == id) {
                arrayView[i].setBackgroundColor(Color.parseColor("#636161"))
            } else {
                arrayView[i].setBackgroundColor(Color.TRANSPARENT)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpArray()
        setUpClickListener()
        setUpModel()

        arFragment = supportFragmentManager.findFragmentById(R.id.scene_form_fragment) as ArFragment

        arFragment.setOnTapArPlaneListener { hitResult, plane, motionEvent ->
            val anchor = hitResult.createAnchor()
            val anchorNode = AnchorNode(anchor)
            anchorNode.setParent(arFragment.arSceneView.scene)

            createModel(anchorNode, selected)
        }

    }

    private fun createModel(anchorNode: AnchorNode, selected: Int) {
        //Bear
        if(selected == 1) {
            val bear = TransformableNode(arFragment.transformationSystem)
            bear.setParent(anchorNode)
            bear.renderable = bearRenderable
            bear.select()

            addName(anchorNode,bear,"Bear")
            //cat
        } else if (selected == 2) {
            val cat = TransformableNode(arFragment.transformationSystem)
            cat.setParent(anchorNode)
            cat.renderable = catRenderable
            cat.select()

            addName(anchorNode,cat,"Cat")
            //cow
        } else if (selected == 3) {
            val cow = TransformableNode(arFragment.transformationSystem)
            cow.setParent(anchorNode)
            cow.renderable = cowRenderable
            cow.select()

            addName(anchorNode,cow,"Cow")
            //dog
        } else if (selected == 4) {
            val dog = TransformableNode(arFragment.transformationSystem)
            dog.setParent(anchorNode)
            dog.renderable = dogRenderable
            dog.select()

            addName(anchorNode,dog,"Dog")
            //elephant
        } else if (selected == 5) {
            val elephant = TransformableNode(arFragment.transformationSystem)
            elephant.setParent(anchorNode)
            elephant.renderable = elephantRenderable
            elephant.select()

            addName(anchorNode,elephant,"Elephant")
            //ferret
        } else if (selected == 6) {
            val ferret = TransformableNode(arFragment.transformationSystem)
            ferret.setParent(anchorNode)
            ferret.renderable = ferretRenderable
            ferret.select()

            addName(anchorNode,ferret,"Ferret")
            //hippo
        } else if (selected == 7) {
            val hippo = TransformableNode(arFragment.transformationSystem)
            hippo.setParent(anchorNode)
            hippo.renderable = hippoRenderable
            hippo.select()

            addName(anchorNode,hippo,"Hippo")
            //horse
        } else if (selected == 8) {
            val horse = TransformableNode(arFragment.transformationSystem)
            horse.setParent(anchorNode)
            horse.renderable = horseRenderable
            horse.select()

            addName(anchorNode,horse,"Horse")
            //koala
        } else if (selected == 9) {
            val koala = TransformableNode(arFragment.transformationSystem)
            koala.setParent(anchorNode)
            koala.renderable = koalaRenderable
            koala.select()

            addName(anchorNode,koala,"Koala")
            //lion
        } else if (selected == 10) {
            val lion = TransformableNode(arFragment.transformationSystem)
            lion.setParent(anchorNode)
            lion.renderable = lionRenderable
            lion.select()

            addName(anchorNode,lion,"Lion")
            //reindeer
        } else if (selected == 11) {
            val reindeer = TransformableNode(arFragment.transformationSystem)
            reindeer.setParent(anchorNode)
            reindeer.renderable = reindeerRenderable
            reindeer.select()

            addName(anchorNode,reindeer,"Reindeer")
            //wolverine
        } else if (selected == 12) {
            val wolverine = TransformableNode(arFragment.transformationSystem)
            wolverine.setParent(anchorNode)
            wolverine.renderable = ferretRenderable
            wolverine.select()

            addName(anchorNode,wolverine,"Wolverine")
        }
    }

    private fun addName(anchorNode: AnchorNode, node: TransformableNode, name: String) {
        ViewRenderable.builder().setView(this,R.layout.name_layout)
            .build()
            .thenAccept { viewRenderable ->
                val nameView = TransformableNode(arFragment.transformationSystem)
                nameView.localPosition = Vector3(0f, node.localPosition.y+0.5f,0f)
                nameView.setParent(anchorNode)
                nameView.renderable = viewRenderable
                nameView.select()

                //set text
                val txt_name = viewRenderable.view as TextView
                txt_name.text = name
                txt_name.setOnClickListener {
                    //click to remove animal
                    anchorNode.setParent(null)
                }
            }

    }


    private fun setUpModel() {

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {


            ModelRenderable.builder()
                .setSource(this, R.raw.bear)
                .build()
                .thenAccept { modelRenderable -> bearRenderable = modelRenderable }
                .exceptionally { throwable ->
                    Toast.makeText(this@MainActivity, "Unable load bear model", Toast.LENGTH_SHORT).show()
                    null
                }

            ModelRenderable.builder()
                .setSource(this, R.raw.cat)
                .build()
                .thenAccept { modelRenderable -> catRenderable = modelRenderable }
                .exceptionally { throwable ->
                    Toast.makeText(this@MainActivity, "Unable load cat model", Toast.LENGTH_SHORT).show()
                    null
                }

            ModelRenderable.builder()
                .setSource(this, R.raw.cow)
                .build()
                .thenAccept { modelRenderable -> cowRenderable = modelRenderable }
                .exceptionally { throwable ->
                    Toast.makeText(this@MainActivity, "Unable load cow model", Toast.LENGTH_SHORT).show()
                    null
                }

            ModelRenderable.builder()
                .setSource(this, R.raw.dog)
                .build()
                .thenAccept { modelRenderable -> dogRenderable = modelRenderable }
                .exceptionally { throwable ->
                    Toast.makeText(this@MainActivity, "Unable load dog model", Toast.LENGTH_SHORT).show()
                    null
                }

            ModelRenderable.builder()
                .setSource(this, R.raw.elephant)
                .build()
                .thenAccept { modelRenderable -> elephantRenderable = modelRenderable }
                .exceptionally { throwable ->
                    Toast.makeText(this@MainActivity, "Unable load elephant model", Toast.LENGTH_SHORT).show()
                    null
                }

            ModelRenderable.builder()
                .setSource(this, R.raw.ferret)
                .build()
                .thenAccept { modelRenderable -> ferretRenderable = modelRenderable }
                .exceptionally { throwable ->
                    Toast.makeText(this@MainActivity, "Unable load ferret model", Toast.LENGTH_SHORT).show()
                    null
                }

            ModelRenderable.builder()
                .setSource(this, R.raw.hippopotamus)
                .build()
                .thenAccept { modelRenderable -> hippoRenderable = modelRenderable }
                .exceptionally { throwable ->
                    Toast.makeText(this@MainActivity, "Unable load hippo model", Toast.LENGTH_SHORT).show()
                    null
                }

            ModelRenderable.builder()
                .setSource(this, R.raw.horse)
                .build()
                .thenAccept { modelRenderable -> horseRenderable = modelRenderable }
                .exceptionally { throwable ->
                    Toast.makeText(this@MainActivity, "Unable load horse model", Toast.LENGTH_SHORT).show()
                    null
                }

            ModelRenderable.builder()
                .setSource(this, R.raw.koala_bear)
                .build()
                .thenAccept { modelRenderable -> koalaRenderable = modelRenderable }
                .exceptionally { throwable ->
                    Toast.makeText(this@MainActivity, "Unable load koala model", Toast.LENGTH_SHORT).show()
                    null
                }

            ModelRenderable.builder()
                .setSource(this, R.raw.lion)
                .build()
                .thenAccept { modelRenderable -> lionRenderable = modelRenderable }
                .exceptionally { throwable ->
                    Toast.makeText(this@MainActivity, "Unable load lion model", Toast.LENGTH_SHORT).show()
                    null
                }

            ModelRenderable.builder()
                .setSource(this, R.raw.reindeer)
                .build()
                .thenAccept { modelRenderable -> reindeerRenderable = modelRenderable }
                .exceptionally { throwable ->
                    Toast.makeText(this@MainActivity, "Unable load reindeer model", Toast.LENGTH_SHORT).show()
                    null
                }

            ModelRenderable.builder()
                .setSource(this, R.raw.wolverine)
                .build()
                .thenAccept { modelRenderable -> wolverineRenderable = modelRenderable }
                .exceptionally { throwable ->
                    Toast.makeText(this@MainActivity, "Unable load wolverine model", Toast.LENGTH_SHORT).show()
                    null
                }
//        }

    }

    private fun setUpClickListener() {
        for(i in arrayView.indices) {
            arrayView[i].setOnClickListener(this)
        }
    }

    private fun setUpArray() {
        arrayView = arrayOf(
            img_bear,
            img_cat,
            img_cow,
            img_dog,
            img_elephant,
            img_ferret,
            img_hippo,
            img_horse,
            img_koala,
            img_lion,
            img_reindeer,
            img_wolverine)
    }
}
