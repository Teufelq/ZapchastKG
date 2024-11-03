package com.example.zapchastkg110.presenation.components.consumer.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.zapchastkg.R
import com.example.zapchastkg110.presenation.components.bases.BaseIcon
import com.example.zapchastkg110.presenation.components.bases.BaseImage
import com.example.zapchastkg110.presenation.components.bases.BaseText
import com.example.zapchastkg110.presenation.ui.theme.Purple
import com.example.zapchastkg110.presenation.utils.Constance

@Composable
fun ProfileHeader() {
    ConstraintLayout(
        modifier = Modifier
            .height(240.dp)
            .background(Purple)
    ) {
        val (topImg, profile, title, back) = createRefs()

        BaseImage(
            painter = painterResource(id = R.drawable.arc_3),
            contentDescription = "Background Arc",
            modifier = Modifier
                .fillMaxWidth()
                .size(45.dp)
                .constrainAs(topImg) {
                    bottom.linkTo(parent.bottom)
                }
        )

        BaseImage(
            painter = painterResource(id = R.drawable.kaktus),
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .constrainAs(profile) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        )

        BaseIcon(
            paint = R.drawable.back,
            tintColor = Color.White,
            modifier = Modifier.constrainAs(back) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start, margin = 24.dp)
            }
        )

        BaseText(
            text = Constance.profileScreen,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
            },
            color = Color.White
        )
    }
}
