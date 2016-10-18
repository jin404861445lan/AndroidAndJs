# AndroidAndJs
Android java代码和Js相互调用
====

java调用js代码
--
1.无参数，java掉js代码
 mWebView.loadUrl("javascript:javacalljs()");

2.带参数调用（直接在js方法拼接参数）
 String hello = "hello";
 mWebView.loadUrl("javascript:javacalljswithargs('" + hello + "')");




 ![image](https://github.com/jin404861445lan/AndroidAndJs/blob/master/pic1.png)
     public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_calljs:

                //无参数，java掉js代码
                mWebView.loadUrl("javascript:javacalljs()");
                break;
            case R.id.btn_calljs_withparam:
                String hello = "hello";
                mWebView.loadUrl("javascript:javacalljswithargs('" + hello + "')");
                break;
        }
    }
