def mailRecipients="surendran.manickam@sap.com, vignesh.r@sap.com, krishnan.sampathkumar@sap.com, poornima.sekar@sap.com, v.srinivasa.chakravarthy@sap.com, hari.prasad.m01@sap.com"

def dev_space = [
        'sic_commit',
        'hcp_staging',
        'aws_commit'
]

def val_space = [
        'sic_staging',
        'aws_staging',
        'sic_aehotfix',
        'aws_aehotfix'
]

def composites_repo_jobs = [
        'iotae_cs_composite_countries',
        'iotae_cs_composite_customers',
        'iotae_cs_composite_locations',
        'iotae_cs_composite_events',
        'iotae_cs_composite_things_pst',
        'iotae_cs_compositethings',
        'iotae_cs_thing_hierarchy_pdms'
]

def configuration_repo_jobs = [
        'iotae_cs_event_severities',
        'iotae_cs_configuration_main',
        'iotae_cs_configuration_pst',
        'iotae_cs_configuration_thingtypes',
        'iotae_cs_configuration_annotation',
        'iotae_cs_thingtype_extension',
        'iotae_cs_event_statuses',
        'iotae_bd_updateconf_deppkg',
        'iotae_bd_updateconfextendedtt',
        'iotae_bd_updatett_hotncoldstore'
]

def core_services_repo_jobs = [
        'iotae_cs_alternateid',
        'iotae_cs_analytics_thing',
        'iotae_cs_detail-thing-sap',
        'iotae_cs_events_aggregate',
        'iotae_cs_events_aggregate_pdms',
        'iotae_cs_odata_geo_json',
        'iotae_cs_bp_analytics_event_type',
        'iotae_cs_odata_advanced_thing_list',
        'iotae_cs_odata_analytics_thing',
        'iotae_cs_odata_bp_analytics_event_type',
        'iotae_cs_odata_postpackage',
        'iotae_cs_odata_pst_property_types',
        'iotae_cs_odata_thing_type_thing_configuration',
        'iotae_cs_odata_thing_configuration_annotation',
        'iotae_cs_odata_thing_configuration_pst',
        'iotae_cs_odata_v2_thing_type_thing_configuration',
        'iotae_cs_odata_multi_lingual_support',
        'iotae_cs_odata_thing_configuration_object_association',
        'iotae_cs_odata_thing_thing_association',
        'iotae_cs_thing_group',
        'iotae_cs_thing_template',
        'iotae_cs_odata_thing_type_extension'
]

def hierarchies_repo_jobs = [
        'iotae_cs_hierarchies'
]

def meta_data_repo_jobs = [
        'iotae_cs_m4',
        'iotae_cs_things_validations',
        'iotae_cs_reference_properties',
        'iotae_cs_snapshot',
        'iotae_cs_thing_id',
        'iotae_cs_thing_pst',
        'iotae_cs_things',
        'iotae_cs_timeseries',
        'iotae_cs_geo_json',
        'iotae_bd_complexreads'
        'iotae_bd_deletethings',
        'iotae_bd_functionalbasic',
        'iotae_bd_timeseriescomplexreads'
]

def thing_hierarchies_repo_jobs = [
        'iotae_cs_thing_hierarchy'
]

def files_repo_jobs = [
        'iotae_cs_file_services'
]

def coldstore_repo_jobs = [
        'iotae_bd_coldstore'
]

def pipelines = [
        'start_composites_repo_jobs',
        'start_configuration_repo_jobs',
        'start_core_services_repo_jobs',
        'start_hierarchies_repo_jobs',
        'start_meta_data_repo_jobs',
        'start_thing_hierarchies_repo_jobs',
        'start_files_repo_jobs',
        'start_coldstore_repo_jobs']

String build_flow_variable = 'JOB_NUMBER: build.properties.get("number"))}'

String start_composites_repo_jobs = composites_repo_jobs.collect{"{build('$it"}.join("', $build_flow_variable,")
String start_configuration_repo_jobs = configuration_repo_jobs.collect{"{build('$it"}.join("', $build_flow_variable,")
String start_core_services_repo_jobs = core_services_repo_jobs.collect{"{build('$it"}.join("', $build_flow_variable,")
String start_hierarchies_repo_jobs = hierarchies_repo_jobs.collect{"{build('$it"}.join("', $build_flow_variable,")
String start_meta_data_repo_jobs = meta_data_repo_jobs.collect{"{build('$it"}.join("', $build_flow_variable,")
String start_thing_hierarchies_repo_jobs = thing_hierarchies_repo_jobs.collect{"{build('$it"}.join("', $build_flow_variable,")
String start_files_repo_jobs = files_repo_jobs.collect{"{build('$it"}.join("', $build_flow_variable,")
String start_coldstore_repo_jobs = coldstore_repo_jobs.collect{"{build('$it"}.join("', $build_flow_variable,")

def giturl_dev = 'https://github.wdf.sap.corp/iot/IoTAE_Development.git'
def giturl_val = 'https://github.wdf.sap.corp/iot/IoTAE_Validation.git'

String branch = '*/functional_test_pipeline'

String goal_string = '.jmx -Dspace='
String goal_string2 = ' -Djob_num=${JOB_NUMBER}'

String env_inject_script = '''JOB_NUMBER=#$(printf "%04d" ${JOB_NUMBER})
echo JOB_NUMBER=${JOB_NUMBER}  > job_no.properties'''

String env_inject_file = 'job_no.properties'

String folder_structure = 'Pipeline_JMX_BOTS'

folder(folder_structure)
{
    description "This folder contains Bots for JMeter test"
}

for (space_item in dev_space)
{
    folder("$folder_structure/$space_item")
    {
        description "This folder contains jmeter jobs for DEVELOPMENT space"
    }
    for (item in composites_repo_jobs)
    {
        mavenJob("$folder_structure/$space_item/$item")
        {
            logRotator(2, 5, 2, 5)
            parameters
            {
                stringParam('JOB_NUMBER', '${BUILD_NUMBER}')
            }
            environmentVariables
            {
                overrideBuildParameters(true)
                keepSystemVariables(true)
                keepBuildVariables(true)
                propertiesFile("$env_inject_file")
                script("$env_inject_script")
            }
            wrappers
            {
                buildUserVars()
                timeout
                {
                    noActivity(1800)
                    abortBuild()
                    writeDescription("Aborted as the job was stuck")
                }
            }
            scm
            {
                git(giturl_dev, branch)
            }
            rootPOM('pom.xml')
            goals("clean validate -DJMETER -DjMeterTestFile=$item$goal_string$space_item$goal_string2")
            publishers
            {
                extendedEmail
                {
                    recipientList(mailRecipients)
                    defaultSubject("Job Failed")
                    defaultContent('$BUILD_URL')
                    triggers
                    {
                        aborted
                        {
                            subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                        }
                    }
                }
            }
        }
    }
    for (item in configuration_repo_jobs)
    {
        mavenJob("$folder_structure/$space_item/$item")
        {
            logRotator(2, 5, 2, 5)
            parameters
            {
                stringParam('JOB_NUMBER', '${BUILD_NUMBER}')
            }
            environmentVariables
            {
                overrideBuildParameters(true)
                keepSystemVariables(true)
                keepBuildVariables(true)
                propertiesFile("$env_inject_file")
                script("$env_inject_script")
            }
            wrappers
            {
                buildUserVars()
                timeout
                {
                    noActivity(1800)
                    abortBuild()
                    writeDescription("Aborted as the job was stuck")
                }
            }
            scm
            {
                git(giturl_dev, branch)
            }
            rootPOM('pom.xml')
            goals("clean validate -DJMETER -DjMeterTestFile=$item$goal_string$space_item$goal_string2")
            publishers
            {
                extendedEmail
                {
                    recipientList(mailRecipients)
                    defaultSubject("Job Failed")
                    defaultContent('$BUILD_URL')
                    triggers
                    {
                        aborted
                        {
                            subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                        }
                    }
                }
            }
        }
    }
    for (item in core_services_repo_jobs)
    {
        mavenJob("$folder_structure/$space_item/$item")
        {
            logRotator(2, 5, 2, 5)
            parameters
            {
                stringParam('JOB_NUMBER', '${BUILD_NUMBER}')
            }
            environmentVariables
            {
                overrideBuildParameters(true)
                keepSystemVariables(true)
                keepBuildVariables(true)
                propertiesFile("$env_inject_file")
                script("$env_inject_script")
            }
            wrappers
            {
                buildUserVars()
                timeout
                {
                    noActivity(1800)
                    abortBuild()
                    writeDescription("Aborted as the job was stuck")
                }
            }
            scm
            {
                git(giturl_dev, branch)
            }
            rootPOM('pom.xml')
            goals("clean validate -DJMETER -DjMeterTestFile=$item$goal_string$space_item$goal_string2")
            publishers
            {
                extendedEmail
                {
                    recipientList(mailRecipients)
                    defaultSubject("Job Failed")
                    defaultContent('$BUILD_URL')
                    triggers
                    {
                        aborted
                        {
                            subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                        }
                    }
                }
            }
        }
    }
    for (item in hierarchies_repo_jobs)
    {
        mavenJob("$folder_structure/$space_item/$item")
        {
            logRotator(2, 5, 2, 5)
            parameters
            {
                stringParam('JOB_NUMBER', '${BUILD_NUMBER}')
            }
            environmentVariables
            {
                overrideBuildParameters(true)
                keepSystemVariables(true)
                keepBuildVariables(true)
                propertiesFile("$env_inject_file")
                script("$env_inject_script")
            }
            wrappers
            {
                buildUserVars()
                timeout
                {
                    noActivity(1800)
                    abortBuild()
                    writeDescription("Aborted as the job was stuck")
                }
            }
            scm
            {
                git(giturl_dev, branch)
            }
            rootPOM('pom.xml')
            goals("clean validate -DJMETER -DjMeterTestFile=$item$goal_string$space_item$goal_string2")
            publishers
            {
                extendedEmail
                {
                    recipientList(mailRecipients)
                    defaultSubject("Job Failed")
                    defaultContent('$BUILD_URL')
                    triggers
                    {
                        aborted
                        {
                            subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                        }
                    }
                }
            }
        }
    }
    for (item in meta_data_repo_jobs)
    {
        mavenJob("$folder_structure/$space_item/$item")
        {
            logRotator(2, 5, 2, 5)
            parameters
            {
                stringParam('JOB_NUMBER', '${BUILD_NUMBER}')
            }
            environmentVariables
            {
                overrideBuildParameters(true)
                keepSystemVariables(true)
                keepBuildVariables(true)
                propertiesFile("$env_inject_file")
                script("$env_inject_script")
            }
            wrappers
            {
                buildUserVars()
                timeout
                {
                    noActivity(1800)
                    abortBuild()
                    writeDescription("Aborted as the job was stuck")
                }
            }
            scm
            {
                git(giturl_dev, branch)
            }
            rootPOM('pom.xml')
            goals("clean validate -DJMETER -DjMeterTestFile=$item$goal_string$space_item$goal_string2")
            publishers
            {
                extendedEmail
                {
                    recipientList(mailRecipients)
                    defaultSubject("Job Failed")
                    defaultContent('$BUILD_URL')
                    triggers
                    {
                        aborted
                        {
                            subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                        }
                    }
                }
            }
        }
    }
    for (item in thing_hierarchies_repo_jobs)
    {
        mavenJob("$folder_structure/$space_item/$item")
        {
            logRotator(2, 5, 2, 5)
            parameters
            {
                stringParam('JOB_NUMBER', '${BUILD_NUMBER}')
            }
            environmentVariables
            {
                overrideBuildParameters(true)
                keepSystemVariables(true)
                keepBuildVariables(true)
                propertiesFile("$env_inject_file")
                script("$env_inject_script")
            }
            wrappers
            {
                buildUserVars()
                timeout
                {
                    noActivity(1800)
                    abortBuild()
                    writeDescription("Aborted as the job was stuck")
                }
            }
            scm
            {
                git(giturl_dev, branch)
            }
            rootPOM('pom.xml')
            goals("clean validate -DJMETER -DjMeterTestFile=$item$goal_string$space_item$goal_string2")
            publishers
            {
                extendedEmail
                {
                    recipientList(mailRecipients)
                    defaultSubject("Job Failed")
                    defaultContent('$BUILD_URL')
                    triggers
                    {
                        aborted
                        {
                            subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                        }
                    }
                }
            }
        }
    }
    for (item in files_repo_jobs)
    {
        mavenJob("$folder_structure/$space_item/$item")
        {
            logRotator(2, 5, 2, 5)
            parameters
            {
                stringParam('JOB_NUMBER', '${BUILD_NUMBER}')
            }
            environmentVariables
            {
                overrideBuildParameters(true)
                keepSystemVariables(true)
                keepBuildVariables(true)
                propertiesFile("$env_inject_file")
                script("$env_inject_script")
            }
            wrappers
            {
                buildUserVars()
                timeout
                {
                    noActivity(1800)
                    abortBuild()
                    writeDescription("Aborted as the job was stuck")
                }
            }
            scm
            {
                git(giturl_dev, branch)
            }
            rootPOM('pom.xml')
            goals("clean validate -DJMETER -DjMeterTestFile=$item$goal_string$space_item$goal_string2")
            publishers
            {
                extendedEmail
                {
                    recipientList(mailRecipients)
                    defaultSubject("Job Failed")
                    defaultContent('$BUILD_URL')
                    triggers
                    {
                        aborted
                        {
                            subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                        }
                    }
                }
            }
        }
    }
    for (item in coldstore_repo_jobs)
    {
        mavenJob("$folder_structure/$space_item/$item")
        {
            logRotator(2, 5, 2, 5)
            parameters
            {
                stringParam('JOB_NUMBER', '${BUILD_NUMBER}')
            }
            environmentVariables
            {
                overrideBuildParameters(true)
                keepSystemVariables(true)
                keepBuildVariables(true)
                propertiesFile("$env_inject_file")
                script("$env_inject_script")
            }
            wrappers
            {
                buildUserVars()
                timeout
                {
                    noActivity(1800)
                    abortBuild()
                    writeDescription("Aborted as the job was stuck")
                }
            }
            scm
            {
                git(giturl_dev, branch)
            }
            rootPOM('pom.xml')
            goals("clean validate -DJMETER -DjMeterTestFile=$item$goal_string$space_item$goal_string2")
            publishers
            {
                extendedEmail
                {
                    recipientList(mailRecipients)
                    defaultSubject("Job Failed")
                    defaultContent('$BUILD_URL')
                    triggers
                    {
                        aborted
                        {
                            subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                        }
                    }
                }
            }
        }
    }
    buildFlowJob("$folder_structure/$space_item/start_composites_repo_jobs")
    {
        buildFlow("parallel ($start_composites_repo_jobs', $build_flow_variable)")
        publishers
        {
            extendedEmail
            {
                recipientList(mailRecipients)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers
                {
                    failure{}
                    aborted
                    {
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
    buildFlowJob("$folder_structure/$space_item/start_configuration_repo_jobs")
    {
        buildFlow("parallel ($start_configuration_repo_jobs', $build_flow_variable)")
        publishers
        {
            extendedEmail
            {
                recipientList(mailRecipients)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers
                {
                    failure{}
                    aborted
                    {
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
    buildFlowJob("$folder_structure/$space_item/start_core_services_repo_jobs")
    {
        buildFlow("parallel ($start_core_services_repo_jobs', $build_flow_variable)")
        publishers
        {
            extendedEmail
            {
                recipientList(mailRecipients)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers
                {
                    failure{}
                    aborted
                    {
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
    buildFlowJob("$folder_structure/$space_item/start_hierarchies_repo_jobs")
    {
        buildFlow("parallel ($start_hierarchies_repo_jobs', $build_flow_variable)")
        publishers
        {
            extendedEmail
            {
                recipientList(mailRecipients)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers
                {
                    failure{}
                    aborted
                    {
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
    buildFlowJob("$folder_structure/$space_item/start_meta_data_repo_jobs")
    {
        buildFlow("parallel ($start_meta_data_repo_jobs', $build_flow_variable)")
        publishers
        {
            extendedEmail
            {
                recipientList(mailRecipients)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers
                {
                    failure{}
                    aborted
                    {
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
    buildFlowJob("$folder_structure/$space_item/start_thing_hierarchies_repo_jobs")
    {
        buildFlow("parallel ($start_thing_hierarchies_repo_jobs', $build_flow_variable)")
        publishers
        {
            extendedEmail
            {
                recipientList(mailRecipients)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers
                {
                    failure{}
                    aborted
                    {
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
    buildFlowJob("$folder_structure/$space_item/start_files_repo_jobs")
    {
        buildFlow("parallel ($start_files_repo_jobs', $build_flow_variable)")
        publishers
        {
            extendedEmail
            {
                recipientList(mailRecipients)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers
                {
                    failure{}
                    aborted
                    {
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
    buildFlowJob("$folder_structure/$space_item/start_coldstore_repo_jobs")
    {
        buildFlow("parallel ($start_coldstore_repo_jobs', $build_flow_variable)")
        publishers
        {
            extendedEmail
            {
                recipientList(mailRecipients)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers
                {
                    failure{}
                    aborted
                    {
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
    buildFlowJob("$folder_structure/$space_item/Start_All")
    {
        buildFlow("parallel ($start_composites_repo_jobs', $build_flow_variable, $start_configuration_repo_jobs', $build_flow_variable, $start_core_services_repo_jobs', $build_flow_variable, $start_hierarchies_repo_jobs', $build_flow_variable, $start_meta_data_repo_jobs', $build_flow_variable, $start_thing_hierarchies_repo_jobs', $build_flow_variable, $start_files_repo_jobs', $build_flow_variable, $start_coldstore_repo_jobs', $build_flow_variable)")
        publishers
        {
            extendedEmail
            {
                recipientList(mailRecipients)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers
                {
                    failure{}
                    aborted
                    {
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
}

for (space_item in val_space)
{
    folder("$folder_structure/$space_item")
    {
        description "This folder contains jmeter jobs for VALIDATION space"
    }
    for (item in composites_repo_jobs)
    {
        mavenJob("$folder_structure/$space_item/$item")
        {
            logRotator(2, 5, 2, 5)
            parameters
            {
                stringParam('JOB_NUMBER', '${BUILD_NUMBER}')
            }
            environmentVariables
            {
                overrideBuildParameters(true)
                keepSystemVariables(true)
                keepBuildVariables(true)
                propertiesFile("$env_inject_file")
                script("$env_inject_script")
            }
            wrappers
            {
                buildUserVars()
                timeout
                {
                    noActivity(1800)
                    abortBuild()
                    writeDescription("Aborted as the job was stuck")
                }
            }
            scm
            {
                git(giturl_val, branch)
            }
            rootPOM('pom.xml')
            goals("clean validate -DJMETER -DjMeterTestFile=$item$goal_string$space_item$goal_string2")
            publishers
            {
                extendedEmail
                {
                    recipientList(mailRecipients)
                    defaultSubject("Job Failed")
                    defaultContent('$BUILD_URL')
                    triggers
                    {
                        aborted
                        {
                            subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                        }
                    }
                }
            }
        }
    }
    for (item in configuration_repo_jobs)
    {
        mavenJob("$folder_structure/$space_item/$item")
        {
            logRotator(2, 5, 2, 5)
            parameters
            {
                stringParam('JOB_NUMBER', '${BUILD_NUMBER}')
            }
            environmentVariables
            {
                overrideBuildParameters(true)
                keepSystemVariables(true)
                keepBuildVariables(true)
                propertiesFile("$env_inject_file")
                script("$env_inject_script")
            }
            wrappers
            {
                buildUserVars()
                timeout
                {
                    noActivity(1800)
                    abortBuild()
                    writeDescription("Aborted as the job was stuck")
                }
            }
            scm
            {
                git(giturl_val, branch)
            }
            rootPOM('pom.xml')
            goals("clean validate -DJMETER -DjMeterTestFile=$item$goal_string$space_item$goal_string2")
            publishers
            {
                extendedEmail
                {
                    recipientList(mailRecipients)
                    defaultSubject("Job Failed")
                    defaultContent('$BUILD_URL')
                    triggers
                    {
                        aborted
                        {
                            subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                        }
                    }
                }
            }
        }
    }
    for (item in core_services_repo_jobs)
    {
        mavenJob("$folder_structure/$space_item/$item")
        {
            logRotator(2, 5, 2, 5)
            parameters
            {
                stringParam('JOB_NUMBER', '${BUILD_NUMBER}')
            }
            environmentVariables
            {
                overrideBuildParameters(true)
                keepSystemVariables(true)
                keepBuildVariables(true)
                propertiesFile("$env_inject_file")
                script("$env_inject_script")
            }
            wrappers
            {
                buildUserVars()
                timeout
                {
                    noActivity(1800)
                    abortBuild()
                    writeDescription("Aborted as the job was stuck")
                }
            }
            scm
            {
                git(giturl_val, branch)
            }
            rootPOM('pom.xml')
            goals("clean validate -DJMETER -DjMeterTestFile=$item$goal_string$space_item$goal_string2")
            publishers
            {
                extendedEmail
                {
                    recipientList(mailRecipients)
                    defaultSubject("Job Failed")
                    defaultContent('$BUILD_URL')
                    triggers
                    {
                        aborted
                        {
                            subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                        }
                    }
                }
            }
        }
    }
    for (item in hierarchies_repo_jobs)
    {
        mavenJob("$folder_structure/$space_item/$item")
        {
            logRotator(2, 5, 2, 5)
            parameters
            {
                stringParam('JOB_NUMBER', '${BUILD_NUMBER}')
            }
            environmentVariables
            {
                overrideBuildParameters(true)
                keepSystemVariables(true)
                keepBuildVariables(true)
                propertiesFile("$env_inject_file")
                script("$env_inject_script")
            }
            wrappers
            {
                buildUserVars()
                timeout
                {
                    noActivity(1800)
                    abortBuild()
                    writeDescription("Aborted as the job was stuck")
                }
            }
            scm
            {
                git(giturl_val, branch)
            }
            rootPOM('pom.xml')
            goals("clean validate -DJMETER -DjMeterTestFile=$item$goal_string$space_item$goal_string2")
            publishers
            {
                extendedEmail
                {
                    recipientList(mailRecipients)
                    defaultSubject("Job Failed")
                    defaultContent('$BUILD_URL')
                    triggers
                    {
                        aborted
                        {
                            subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                        }
                    }
                }
            }
        }
    }
    for (item in meta_data_repo_jobs)
    {
        mavenJob("$folder_structure/$space_item/$item")
        {
            logRotator(2, 5, 2, 5)
            parameters
            {
                stringParam('JOB_NUMBER', '${BUILD_NUMBER}')
            }
            environmentVariables
            {
                overrideBuildParameters(true)
                keepSystemVariables(true)
                keepBuildVariables(true)
                propertiesFile("$env_inject_file")
                script("$env_inject_script")
            }
            wrappers
            {
                buildUserVars()
                timeout
                {
                    noActivity(1800)
                    abortBuild()
                    writeDescription("Aborted as the job was stuck")
                }
            }
            scm
            {
                git(giturl_val, branch)
            }
            rootPOM('pom.xml')
            goals("clean validate -DJMETER -DjMeterTestFile=$item$goal_string$space_item$goal_string2")
            publishers
            {
                extendedEmail
                {
                    recipientList(mailRecipients)
                    defaultSubject("Job Failed")
                    defaultContent('$BUILD_URL')
                    triggers
                    {
                        aborted
                        {
                            subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                        }
                    }
                }
            }
        }
    }
    for (item in thing_hierarchies_repo_jobs)
    {
        mavenJob("$folder_structure/$space_item/$item")
        {
            logRotator(2, 5, 2, 5)
            parameters
            {
                stringParam('JOB_NUMBER', '${BUILD_NUMBER}')
            }
            environmentVariables
            {
                overrideBuildParameters(true)
                keepSystemVariables(true)
                keepBuildVariables(true)
                propertiesFile("$env_inject_file")
                script("$env_inject_script")
            }
            wrappers
            {
                buildUserVars()
                timeout
                {
                    noActivity(1800)
                    abortBuild()
                    writeDescription("Aborted as the job was stuck")
                }
            }
            scm
            {
                git(giturl_val, branch)
            }
            rootPOM('pom.xml')
            goals("clean validate -DJMETER -DjMeterTestFile=$item$goal_string$space_item$goal_string2")
            publishers
            {
                extendedEmail
                {
                    recipientList(mailRecipients)
                    defaultSubject("Job Failed")
                    defaultContent('$BUILD_URL')
                    triggers
                    {
                        aborted
                        {
                            subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                        }
                    }
                }
            }
        }
    }
    for (item in files_repo_jobs)
    {
        mavenJob("$folder_structure/$space_item/$item")
        {
            logRotator(2, 5, 2, 5)
            parameters
            {
                stringParam('JOB_NUMBER', '${BUILD_NUMBER}')
            }
            environmentVariables
            {
                overrideBuildParameters(true)
                keepSystemVariables(true)
                keepBuildVariables(true)
                propertiesFile("$env_inject_file")
                script("$env_inject_script")
            }
            wrappers
            {
                buildUserVars()
                timeout
                {
                    noActivity(1800)
                    abortBuild()
                    writeDescription("Aborted as the job was stuck")
                }
            }
            scm
            {
                git(giturl_val, branch)
            }
            rootPOM('pom.xml')
            goals("clean validate -DJMETER -DjMeterTestFile=$item$goal_string$space_item$goal_string2")
            publishers
            {
                extendedEmail
                {
                    recipientList(mailRecipients)
                    defaultSubject("Job Failed")
                    defaultContent('$BUILD_URL')
                    triggers
                    {
                        aborted
                        {
                            subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                        }
                    }
                }
            }
        }
    }
    for (item in coldstore_repo_jobs)
    {
        mavenJob("$folder_structure/$space_item/$item")
        {
            logRotator(2, 5, 2, 5)
            parameters
            {
                stringParam('JOB_NUMBER', '${BUILD_NUMBER}')
            }
            environmentVariables
            {
                overrideBuildParameters(true)
                keepSystemVariables(true)
                keepBuildVariables(true)
                propertiesFile("$env_inject_file")
                script("$env_inject_script")
            }
            wrappers
            {
                buildUserVars()
                timeout
                {
                    noActivity(1800)
                    abortBuild()
                    writeDescription("Aborted as the job was stuck")
                }
            }
            scm
            {
                git(giturl_val, branch)
            }
            rootPOM('pom.xml')
            goals("clean validate -DJMETER -DjMeterTestFile=$item$goal_string$space_item$goal_string2")
            publishers
            {
                extendedEmail
                {
                    recipientList(mailRecipients)
                    defaultSubject("Job Failed")
                    defaultContent('$BUILD_URL')
                    triggers
                    {
                        aborted
                        {
                            subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                        }
                    }
                }
            }
        }
    }
    buildFlowJob("$folder_structure/$space_item/start_composites_repo_jobs")
    {
        buildFlow("parallel ($start_composites_repo_jobs', $build_flow_variable)")
        publishers
        {
            extendedEmail
            {
                recipientList(mailRecipients)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers
                {
                    failure{}
                    aborted
                    {
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
    buildFlowJob("$folder_structure/$space_item/start_configuration_repo_jobs")
    {
        buildFlow("parallel ($start_configuration_repo_jobs', $build_flow_variable)")
        publishers
        {
            extendedEmail
            {
                recipientList(mailRecipients)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers
                {
                    failure{}
                    aborted
                    {
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
    buildFlowJob("$folder_structure/$space_item/start_core_services_repo_jobs")
    {
        buildFlow("parallel ($start_core_services_repo_jobs', $build_flow_variable)")
        publishers
        {
            extendedEmail
            {
                recipientList(mailRecipients)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers
                {
                    failure{}
                    aborted
                    {
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
    buildFlowJob("$folder_structure/$space_item/start_hierarchies_repo_jobs")
    {
        buildFlow("parallel ($start_hierarchies_repo_jobs', $build_flow_variable)")
        publishers
        {
            extendedEmail
            {
                recipientList(mailRecipients)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers
                {
                    failure{}
                    aborted
                    {
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
    buildFlowJob("$folder_structure/$space_item/start_meta_data_repo_jobs")
    {
        buildFlow("parallel ($start_meta_data_repo_jobs', $build_flow_variable)")
        publishers
        {
            extendedEmail
            {
                recipientList(mailRecipients)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers
                {
                    failure{}
                    aborted
                    {
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
    buildFlowJob("$folder_structure/$space_item/start_thing_hierarchies_repo_jobs")
    {
        buildFlow("parallel ($start_thing_hierarchies_repo_jobs', $build_flow_variable)")
        publishers
        {
            extendedEmail
            {
                recipientList(mailRecipients)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers
                {
                    failure{}
                    aborted
                    {
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
    buildFlowJob("$folder_structure/$space_item/start_files_repo_jobs")
    {
        buildFlow("parallel ($start_files_repo_jobs', $build_flow_variable)")
        publishers
        {
            extendedEmail
            {
                recipientList(mailRecipients)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers
                        {
                            failure{}
                            aborted
                                    {
                                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                                    }
                        }
            }
        }
    }
    buildFlowJob("$folder_structure/$space_item/start_coldstore_repo_jobs")
    {
        buildFlow("parallel ($start_coldstore_repo_jobs', $build_flow_variable)")
        publishers
        {
            extendedEmail
            {
                recipientList(mailRecipients)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers
                {
                    failure{}
                    aborted
                    {
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
    buildFlowJob("$folder_structure/$space_item/Start_All")
    {
        buildFlow("parallel ($start_composites_repo_jobs', $build_flow_variable, $start_configuration_repo_jobs', $build_flow_variable, $start_core_services_repo_jobs', $build_flow_variable, $start_hierarchies_repo_jobs', $build_flow_variable, $start_meta_data_repo_jobs', $build_flow_variable, $start_thing_hierarchies_repo_jobs', $build_flow_variable, $start_files_repo_jobs', $build_flow_variable, $start_coldstore_repo_jobs', $build_flow_variable)")
        publishers
        {
            extendedEmail
            {
                recipientList(mailRecipients)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers
                {
                    failure{}
                    aborted
                    {
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
}

sectionedView('Pipeline_JMX_BOTS')
{
    sections
    {
        listView
        {
            name('DEVELOPMENT TEST JMETER BOTS')
            width('FULL')
            alignment('LEFT')
            jobs
            {
                for (item in dev_space)
                {
                    name("$folder_structure/$item")
                }
            }
            columns
            {
                status()
                weather()
                name()
                lastSuccess()
                lastFailure()
            }
        }
        listView
        {
            name('VALIDATION TEST JMETER BOTS')
            width('FULL')
            alignment('LEFT')
            jobs
            {
                for (item in val_space)
                {
                    name("$folder_structure/$item")
                }
            }
            columns
            {
                status()
                weather()
                name()
                lastSuccess()
                lastFailure()
            }
        }
    }
}
