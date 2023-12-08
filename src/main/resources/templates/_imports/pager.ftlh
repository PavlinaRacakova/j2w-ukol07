[#ftl]

[#macro pagerLink page text active]
    [#if active]
        <span class="page active">${text}</span>
    [#else ]
        <a href="${createURL({"size": postList.size, "page": page})}" class="page">${text}</a>
    [/#if]
[/#macro]