package com.example.zapchastkg110.presenation.utils

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zapchastkg.R

object Constance{
    const val boardTitle1 = "Здравствуйте!"
    const val boardTitle2 = "Цель приложения"
    const val boardTitle3 = "Удачи в приложении"
    const val boardDescription1 = "Мы рады приветствовать вас в своем приложении. Хотите узать наши цели?"
    const val boardDescription2 = "Наша цель облегчить для вас поиск запчастей, и их продажу\n"
    const val boardDescription3 = "Легких покупок и быстрых продаж!"
    const val chooseRoleName = "Выберите роль"
    const val chooseRoleTitle1 = "Коммерсант"
    const val chooseRoleDescription1= "Продавайте свои товары с полным удобством. Регистрируйте свой магазин или осуществляйте продажи онлайн, не выходя из дома."
    const val chooseRoleTitle2 = "Покупатель"
    const val chooseRoleDescription2 = "Ищите товары с комфортом, где бы вы ни находились. В приложении вас ждет удобная система поиска и легкая покупка"
    const val consumerSellerSignUpName = "Регистрация"
    const val loginScreenName = "Вход"
    const val editTextName = "Имя"
    const val editTextEmail = "Электронная почта"
    const val editTextPhone = "Номер телефона"
    const val editTextPassword = "Пароль"
    const val editTextAddress = "Адрес"
    const val editTextEmailOrPhone = "Эл. почта или номер телефона"
    const val labelName = "Напишите ваше имя"
    const val labelEmail = "Напишите вашу почту"
    const val labelPhone = "Напишите ваш номер телефона"
    const val labelPassword = "Придумайте ваш пароль"
    const val labelSignInPassword = "Ваш пароль"
    const val labelEmailOrPhone = "Укажите номер тел. или эл. почту"
    const val labelAddress = "Укажите ваш точный адрес"
    const val consumerName = "Покупатель"
    const val sellerName = "Коммерсант"
    const val btnSignUp = "войти"
    const val alreadyHasAnAccount = "Уже есть аккаунт?"
    const val dontHaveAnAccount = "Нет аккаунта?"
    const val registr = "Регистрация"
    const val enter = "Вход"
    const val forgotPassword = "Забыли пароль?"
    const val forgotScreenName = "Восстановление"
    const val attentionTitle = "ВНИМАНИЕ"
    const val attentionDescription= "МЫ ОТПРАВИЛИ ПЯТИЗНАЧНЫЙ\n" +
            "КОД НА ВАШ СОТОВЫЙ НОМЕР"
    const val attentionCode = "ВАШ КОД"
    const val verify = "ПОДТВЕРДИТЬ"
    const val mainScreenName = "Рекомендации"
    const val SearchScreenName = "Поиск"
    const val favScreenName = "Фавориты"
    const val profileScreen = "Профиль"
    const val ChatName = "Чаты"
    const val BASE_URL = "https://zapchast.com.kg/api/"
    const val seller = "seller"
    const val consumer = "client"
}

@Composable
fun CircularProgressBar(
    percentage: Float,
    number: Int,
    fontSize: TextUnit = 18.sp,
    radius: Dp = 22.dp,
    color: Color = Color.White,
    strokeWidth: Dp = 6.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0
) {
    var animPlayed by remember {
        mutableStateOf(false)
    }
    val curPercentage =
        animateFloatAsState(
            targetValue = if (animPlayed) percentage else 0f, animationSpec = tween(
                delayMillis = animDelay
            ), label = ""
        )
    LaunchedEffect(key1 = true) {
        animPlayed = true
    }

    Box(contentAlignment = Alignment.Center, modifier = Modifier.size(radius * 2f)) {
        Canvas(modifier = Modifier.size(radius * 2f)) {
            drawArc(
                color = color,
                -90f,
                360 * curPercentage.value,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }
        Text(
            text = (curPercentage.value * number).toInt().toString(),
            fontFamily = FontFamily(Font(R.font.favbask)),
            fontWeight = FontWeight.Bold,
            fontSize = fontSize,
            color = color
        )
    }
}

    @Composable
    fun MyToast(message: String) {
        android.widget.Toast.makeText(LocalContext.current, message, android.widget.Toast.LENGTH_SHORT).show()
    }

