
import com.example.kotlin_mvvm_wananzhuo.bean.Banner_Bean
import com.example.kotlin_mvvm_wananzhuo.bean.Show_Bean
import com.example.kotlin_mvvm_wananzhuo.bean.Tab_bean
import com.example.kotlin_mvvm_wananzhuo.bean.Xian_Bean
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface   ApiService {
    //首页Banner
    @GET("banner/json")
    suspend fun Bann():Banner_Bean
    //首页列表
    @GET("article/list/{page}/json")
    suspend fun ShouList(@Path("page") page: Int): Show_Bean
    //项目Tab
    @GET("project/tree/json")
    suspend fun XianTab(): Tab_bean
    //项目列表
    @GET("project/list/1/json?")
    suspend fun XianList(@Query("cid") cid: Int): Xian_Bean
}