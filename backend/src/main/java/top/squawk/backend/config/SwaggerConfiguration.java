package top.squawk.backend.config;


import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SwaggerConfiguration {
    /**
     * 创建Docket类型的对象。并使用spring容器管理。
     * Docket是Swagger中的全局配置对象
     *
     * @return
     */
    @Bean
    public Docket docket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        //API帮助文档的描述信息。imformation
        ApiInfo apiInfo =
                new ApiInfoBuilder()
                        .contact(//配置Swagger文档主体内容。
                                new Contact(
                                        "This is Swagger 开发文档（By rainbow）", //是文档的发布者名称
                                        "http://www.squawk.top",    //是文档发布者的网站地址。企业网站
                                        "1103356347@qq.com")    //文档发布者的电子邮箱
                        )
                        .title("Swagger框架学习帮助文档（By rainbow）")
                        .description("Swagger框架学习帮助文档详细信息-Swagger框架是一个用于开发RestAPI帮助文档的框架")
                        .version("1.1")
                        .build();

        //给docket上下文设置配置api描述信息
        docket.apiInfo(apiInfo);


        //自定义注解实现不生成（base-error)的帮助文档
        docket = docket
                .select()//获取Docket中的选择器。返回ApiSelectorBuilder。构建选择器的。如：扫描什么包的注解。
                .apis(RequestHandlerSelectors.basePackage("top.squawk.backend.controller"))    //设定扫描哪个包（包含子包）中的注解。
                .paths(
                        Predicates.or(
                                PathSelectors.regex("/.*")//路径范围匹配
                        )

                )
                .build();//重新构建docket对象
        return docket;
    }
}
