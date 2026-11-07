package com.linked.game

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Vector2

class LinkedGame : ApplicationAdapter() {

    private lateinit var renderer: ShapeRenderer
    private lateinit var camera: OrthographicCamera

    private val players = mutableListOf<Vector2>()

    private val colors = arrayOf(
        floatArrayOf(0.2f, 0.5f, 1f),
        floatArrayOf(1f, 0.2f, 0.2f),
        floatArrayOf(1f, 0.8f, 0.1f),
        floatArrayOf(0.2f, 0.9f, 0.3f),
        floatArrayOf(0.7f, 0.3f, 1f),
        floatArrayOf(1f, 0.5f, 0.1f)
    )

    override fun create() {
        renderer = ShapeRenderer()

        camera = OrthographicCamera()
        camera.setToOrtho(false, 800f, 480f)

        val startX = 170f
        val spacing = 90f

        repeat(6) { index ->
            players.add(
                Vector2(
                    startX + index * spacing,
                    240f
                )
            )
        }
    }

    override fun render() {
        Gdx.gl.glClearColor(0.08f, 0.10f, 0.16f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        camera.update()
        renderer.projectionMatrix = camera.combined

        // Draw rope network
        renderer.begin(ShapeRenderer.ShapeType.Line)
        renderer.color.set(0.85f, 0.9f, 1f, 1f)

        for (i in 0 until players.size) {
            for (j in i + 1 until players.size) {
                renderer.line(players[i], players[j])
            }
        }

        renderer.end()

        // Draw players
        renderer.begin(ShapeRenderer.ShapeType.Filled)

        players.forEachIndexed { index, position ->
            val color = colors[index]

            renderer.setColor(
                color[0],
                color[1],
                color[2],
                1f
            )

            renderer.circle(
                position.x,
                position.y,
                18f
            )
        }

        renderer.end()
    }

    override fun resize(width: Int, height: Int) {
        camera.setToOrtho(false, 800f, 480f)
    }

    override fun dispose() {
        renderer.dispose()
    }
}
