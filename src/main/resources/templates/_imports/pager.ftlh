[#ftl]

[#macro pagerLink page text linkCanContinue]
    [#if linkCanContinue]
        <a href="${createURL({"size": postList.size, "page": page})}" class="page">${text}</a>
    [#else ]
        <span class="page cannotContinue">${text}</span>
    [/#if]
[/#macro]