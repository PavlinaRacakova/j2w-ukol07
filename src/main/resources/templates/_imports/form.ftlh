[#ftl]

[#macro errors name]

    [#if bindStatus.hasFieldErrors(name)]
        <ul class="error">
            [#list bindStatus.getFieldErrors(name) as error]
                <li>${error.defaultMessage}</li>
            [/#list]
        </ul>
    [/#if]

[/#macro]
