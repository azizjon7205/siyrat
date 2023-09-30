package uz.bismillah.siyrat.data.repository

import android.content.SharedPreferences
import uz.bismillah.siyrat.data.resourse.local.room.Salovat
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SalovatRepository @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    fun getSalovat(id:Int):Salovat?{
        for (item in listSalovat){
            if (id == item.id){
                return item
            }
        }
        return null
    }

    fun updateSalovat(id: Int,count:Int){
        getSalovat(id)?.allCount = getSalovat(id)?.allCount!!.plus(count)
    }

   val listSalovat:List<Salovat> = listOf(
       Salovat(
            0,
            "ٱللَّٰهُمَّ صَلِّ عَلَىٰ مُحَمَّدٍ وَعَلَىٰ آلِ مُحَمَّدٍ",
            "Allohumma solli a’la Muhammadin va `alaa aali Muhammad",
            0,
            0
        ),
        Salovat(
            1,
            "اللَّهُمَّ صَلِّ عَلَى مُحَمَّدٍ وَعَلَى آلِ مُحَمَّدٍ، كَمَا صَلَّيْتَ عَلَى إِبْرَاهِيمَ وآلِ إِبْرَاهِيمَ، وَبَارِكْ َلَى مُحَمَّدٍ وَآلِ مُحَمَّدٍ، كَمَا بَارَكْتَ عَلَى إِبْرَاهِيمَ وَآلِ إِبْرَاهِيمَ إِنَّكَ حَمِيدٌ مَجِيدٌ.",
            "Allohumma solli ʼalaa Muhammadiv va ʼalaa ali Muhammad. Kama sollayta ʼalaa Ibrohiyma va ali Ibrohiym. Va barik ʼalaa Muhammadiv va ali Muhammad. Kama barokta ʼalaa Ibrohiyma va ali Ibrohiym. Innaka hamiydum majid",
            0,
            0
        ),
        Salovat(
            2,
            "اللَّهُمَّ صَلِّ عَلَى مُحَمَّدٍ ، وَأَنْزِلْهُ الْمَقْعَدَ الْمُقَرَّبَ مِنْكَ يَوْمَ الْقِيَامَةٍِ",
            "Allohumma solli ʼalaa Muhammadin va anzilhul maqʼadal muqorroba minka yavmal qiyamah",
            0,
            0
        ),
        Salovat(
            3,
            "اللَّهُمَّ صَلِّ وَسَلِّمْ وَبَارِكْ عَلَى مُحَمَّدٍٍ",
            "Allohumma solli vasallim va barik a'la Muhammad",
            0,
            0
        ),
        Salovat(
            4,
            "اللَّهُمَّ صَلِّ وَ سَلِّمْ وَ بَارِكْ عَلَى سَيِّدِنَا مُحَمَّدٍ وَ عَلَى آلِهِ وَ ارْضَ عَنْ أَصْحَابِهِ أَجْمَعِينٍ",
            "Allohumma, solli va sallim va baarik ʼalaa sayyidinaa Muhammadin va ʼalaa aalihi vardo ʼan asʼhaabihi ajmaʼiyn",
            0,
            0
        ),
        Salovat(
            5,
            "صلى الله عليه وسلمٍ",
            "Salla Allahu 'alayh wa sallam",
            0,
            0
        )
       ,
       Salovat(
           6,
           "الصلاة والسلام عليك يا رسول اللهٍ",
           "As-salatu wa as-salamu 'alayka ya Rasul Allah.",
           0,
           0
       )
       ,
       Salovat(
           7,
           "صلي الله عليه وآله وسلمٍ",
           "Salli Allah 'alayh wa aalihi wa sallam.",
           0,
           0
       )

    )

}