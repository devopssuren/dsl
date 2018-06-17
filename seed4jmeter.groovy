def mailRecipients_CS="surendran.manickam@sap.com, vignesh.r@sap.com, krishnan.sampathkumar@sap.com, v.srinivasa.chakravarthy@sap.com, hari.prasad.m01@sap.com"
def mailRecipients_BD="surendran.manickam@sap.com, vignesh.r@sap.com, krishnan.sampathkumar@sap.com, poornima.sekar@sap.com, v.srinivasa.chakravarthy@sap.com"

def dev_space = [
'sic_commit',
'aws_commit'
]

def val_space = [
'sic_staging',
'aws_staging',
'sic_aehotfix',
'aws_aehotfix'
]

def rel_space = [
'sagdf_staging',
'sagdf_live',
'sagdf_live_beta',
'aws_eu_live'
]

def job_bd = [
'iotae_bd_coldstore',
'iotae_bd_complexreads',
'iotae_bd_dataingestion',
'iotae_bd_deletethings',
'iotae_bd_functionalbasic',
'iotae_bd_m4',
'iotae_bd_m4minmaxmultiple',
'iotae_bd_snapshot',
'iotae_bd_timeseriescomplexreads',
'iotae_bd_updateconf_deppkg',
'iotae_bd_updateconfextendedtt',
'iotae_bd_updatepst',
'iotae_bd_updatepst_coldstore',
'iotae_bd_updatepst_hotncoldstore',
'iotae_bd_updatepst_hotstore',
'iotae_bd_updatett',
'iotae_bd_updatett_coldstore',
'iotae_bd_updatett_hotncoldstore',
'iotae_bd_updatett_hotstore'
]

def sic_commit_job = [
'iotae_cs_alternateid',
'iotae_cs_analytics_thing',
'iotae_cs_bp_analytics_event_type',
'iotae_cs_caching',
'iotae_cs_composite_countries',
'iotae_cs_composite_customers',
'iotae_cs_composite_events',
'iotae_cs_composite_locations',
'iotae_cs_composite_things_pst',
'iotae_cs_compositethings',
'iotae_cs_configuration_annotation',
'iotae_cs_configuration_main',
'iotae_cs_configuration_pst',
'iotae_cs_configuration_thingtypes',
'iotae_cs_detail_thing_sap',
'iotae_cs_event_severities',
'iotae_cs_event_statuses',
'iotae_cs_events',
'iotae_cs_events_aggregate',
'iotae_cs_events_aggregate_pdms',
'iotae_cs_events_validations',
'iotae_cs_file_services',
'iotae_cs_geo_json',
'iotae_cs_hierarchies',
'iotae_cs_m4',
'iotae_cs_odata_advanced_thing_list',
'iotae_cs_odata_analytics_thing',
'iotae_cs_odata_bp_analytics_event_type',
'iotae_cs_odata_caching',
'iotae_cs_odata_geo_json',
'iotae_cs_odata_multi_lingual_support',
'iotae_cs_odata_postpackage',
'iotae_cs_odata_pst_property_types',
'iotae_cs_odata_thing_configuration_annotation',
'iotae_cs_odata_thing_configuration_object_association',
'iotae_cs_odata_thing_configuration_pst',
'iotae_cs_odata_thing_thing_association',
'iotae_cs_odata_thing_type_extension',
'iotae_cs_odata_thing_type_thing_configuration',
'iotae_cs_odata_unfied_events_pst',
'iotae_cs_odata_unified_events_config_event_types',
'iotae_cs_odata_unified_events_event_types_events',
'iotae_cs_odata_v2_thing_type_thing_configuration',
'iotae_cs_put_data_for_multiple_things',
'iotae_cs_reference_properties',
'iotae_cs_snapshot',
'iotae_cs_tenant_specific_validation',
'iotae_cs_thing_group',
'iotae_cs_thing_hierarchy',
'iotae_cs_thing_id',
'iotae_cs_thing_pst',
'iotae_cs_thing_template',
'iotae_cs_things',
'iotae_cs_things_validations',
'iotae_cs_thingtype_extension',
'iotae_cs_timeseries',
'iotae_cs_typedevents'
]

def aws_commit_job = [
'Demo_Script',
'iotae_cs_alternateid',
'iotae_cs_analytics_thing',
'iotae_cs_bp_analytics_event_type',
'iotae_cs_caching',
'iotae_cs_composite_countries',
'iotae_cs_composite_customers',
'iotae_cs_composite_events',
'iotae_cs_composite_locations',
'iotae_cs_composite_things_pst',
'iotae_cs_compositethings',
'iotae_cs_configuration_annotation',
'iotae_cs_configuration_main',
'iotae_cs_configuration_pst',
'iotae_cs_configuration_thingtypes',
'iotae_cs_detail_thing_sap',
'iotae_cs_event_severities',
'iotae_cs_event_statuses',
'iotae_cs_events',
'iotae_cs_events_aggregate',
'iotae_cs_events_aggregate_pdms',
'iotae_cs_events_validations',
'iotae_cs_file_services',
'iotae_cs_geo_json',
'iotae_cs_hierarchies',
'iotae_cs_m4',
'iotae_cs_odata_advanced_thing_list',
'iotae_cs_odata_analytics_thing',
'iotae_cs_odata_bp_analytics_event_type',
'iotae_cs_odata_caching',
'iotae_cs_odata_composite_events',
'iotae_cs_odata_composite_events_event_type',
'iotae_cs_odata_composite_things',
'iotae_cs_odata_geo_json',
'iotae_cs_odata_multi_lingual_support',
'iotae_cs_odata_postpackage',
'iotae_cs_odata_pst_property_types',
'iotae_cs_odata_thing_configuration_annotation',
'iotae_cs_odata_thing_configuration_object_association',
'iotae_cs_odata_thing_configuration_pst',
'iotae_cs_odata_thing_thing_association',
'iotae_cs_odata_thing_type_extension',
'iotae_cs_odata_thing_type_thing_configuration',
'iotae_cs_odata_unfied_events_pst',
'iotae_cs_odata_unified_events_config_event_types',
'iotae_cs_odata_unified_events_event_types_events',
'iotae_cs_odata_v2_thing_type_thing_configuration',
'iotae_cs_package_sharing',
'iotae_cs_put_data_for_multiple_things',
'iotae_cs_reference_properties',
'iotae_cs_snapshot',
'iotae_cs_tenant_specific_validation',
'iotae_cs_thing_group',
'iotae_cs_thing_hierarchy',
'iotae_cs_thing_hierarchy_pdms',
'iotae_cs_thing_id',
'iotae_cs_thing_pst',
'iotae_cs_thing_template',
'iotae_cs_things',
'iotae_cs_things_validations',
'iotae_cs_thingtype_extension',
'iotae_cs_timeseries',
'iotae_cs_typedevents'
]

def sic_staging_job = [
'iotae_cs_alternateid',
'iotae_cs_analytics_thing',
'iotae_cs_bp_analytics_event_type',
'iotae_cs_caching',
'iotae_cs_composite_countries',
'iotae_cs_composite_customers',
'iotae_cs_composite_events',
'iotae_cs_composite_locations',
'iotae_cs_composite_things_pst',
'iotae_cs_compositethings',
'iotae_cs_configuration_annotation',
'iotae_cs_configuration_main',
'iotae_cs_configuration_pst',
'iotae_cs_configuration_thingtypes',
'iotae_cs_detail_thing_sap',
'iotae_cs_event_severities',
'iotae_cs_event_statuses',
'iotae_cs_events',
'iotae_cs_events_aggregate',
'iotae_cs_events_aggregate_pdms',
'iotae_cs_events_validations',
'iotae_cs_file_services',
'iotae_cs_geo_json',
'iotae_cs_hierarchies',
'iotae_cs_m4',
'iotae_cs_odata_advanced_thing_list',
'iotae_cs_odata_analytics_thing',
'iotae_cs_odata_bp_analytics_event_type',
'iotae_cs_odata_caching',
'iotae_cs_odata_geo_json',
'iotae_cs_odata_multi_lingual_support',
'iotae_cs_odata_postpackage',
'iotae_cs_odata_pst_property_types',
'iotae_cs_odata_thing_configuration_annotation',
'iotae_cs_odata_thing_configuration_object_association',
'iotae_cs_odata_thing_configuration_pst',
'iotae_cs_odata_thing_thing_association',
'iotae_cs_odata_thing_type_extension',
'iotae_cs_odata_thing_type_thing_configuration',
'iotae_cs_odata_unfied_events_pst',
'iotae_cs_odata_unified_events_config_event_types',
'iotae_cs_odata_unified_events_event_types_events',
'iotae_cs_odata_v2_thing_type_thing_configuration',
'iotae_cs_put_data_for_multiple_things',
'iotae_cs_reference_properties',
'iotae_cs_snapshot',
'iotae_cs_tenant_specific_validation',
'iotae_cs_thing_group',
'iotae_cs_thing_hierarchy',
'iotae_cs_thing_id',
'iotae_cs_thing_pst',
'iotae_cs_thing_template',
'iotae_cs_things',
'iotae_cs_things_validations',
'iotae_cs_thingtype_extension',
'iotae_cs_timeseries',
'iotae_cs_typedevents'
]

def aws_staging_job = [
'Demo_Script',
'iotae_cs_alternateid',
'iotae_cs_analytics_thing',
'iotae_cs_bp_analytics_event_type',
'iotae_cs_caching',
'iotae_cs_composite_countries',
'iotae_cs_composite_customers',
'iotae_cs_composite_events',
'iotae_cs_composite_locations',
'iotae_cs_composite_things_pst',
'iotae_cs_compositethings',
'iotae_cs_configuration_annotation',
'iotae_cs_configuration_main',
'iotae_cs_configuration_pst',
'iotae_cs_configuration_thingtypes',
'iotae_cs_detail_thing_sap',
'iotae_cs_event_severities',
'iotae_cs_event_statuses',
'iotae_cs_events',
'iotae_cs_events_aggregate',
'iotae_cs_events_aggregate_pdms',
'iotae_cs_events_validations',
'iotae_cs_file_services',
'iotae_cs_geo_json',
'iotae_cs_hierarchies',
'iotae_cs_m4',
'iotae_cs_odata_advanced_thing_list',
'iotae_cs_odata_analytics_thing',
'iotae_cs_odata_bp_analytics_event_type',
'iotae_cs_odata_caching',
'iotae_cs_odata_composite_events',
'iotae_cs_odata_composite_events_event_type',
'iotae_cs_odata_composite_things',
'iotae_cs_odata_geo_json',
'iotae_cs_odata_multi_lingual_support',
'iotae_cs_odata_postpackage',
'iotae_cs_odata_pst_property_types',
'iotae_cs_odata_thing_configuration_annotation',
'iotae_cs_odata_thing_configuration_object_association',
'iotae_cs_odata_thing_configuration_pst',
'iotae_cs_odata_thing_thing_association',
'iotae_cs_odata_thing_type_extension',
'iotae_cs_odata_thing_type_thing_configuration',
'iotae_cs_odata_unfied_events_pst',
'iotae_cs_odata_unified_events_config_event_types',
'iotae_cs_odata_unified_events_event_types_events',
'iotae_cs_odata_v2_thing_type_thing_configuration',
'iotae_cs_package_sharing',
'iotae_cs_put_data_for_multiple_things',
'iotae_cs_reference_properties',
'iotae_cs_snapshot',
'iotae_cs_tenant_specific_validation',
'iotae_cs_thing_group',
'iotae_cs_thing_hierarchy',
'iotae_cs_thing_hierarchy_pdms',
'iotae_cs_thing_id',
'iotae_cs_thing_pst',
'iotae_cs_thing_template',
'iotae_cs_things',
'iotae_cs_things_validations',
'iotae_cs_thingtype_extension',
'iotae_cs_timeseries',
'iotae_cs_typedevents'
]

def sic_aehotfix_job = [
'iotae_cs_alternateid',
'iotae_cs_analytics_thing',
'iotae_cs_bp_analytics_event_type',
'iotae_cs_caching',
'iotae_cs_composite_countries',
'iotae_cs_composite_customers',
'iotae_cs_composite_events',
'iotae_cs_composite_locations',
'iotae_cs_composite_things_pst',
'iotae_cs_compositethings',
'iotae_cs_configuration_annotation',
'iotae_cs_configuration_main',
'iotae_cs_configuration_pst',
'iotae_cs_configuration_thingtypes',
'iotae_cs_detail_thing_sap',
'iotae_cs_event_severities',
'iotae_cs_event_statuses',
'iotae_cs_events',
'iotae_cs_events_aggregate',
'iotae_cs_events_aggregate_pdms',
'iotae_cs_events_validations',
'iotae_cs_file_services',
'iotae_cs_geo_json',
'iotae_cs_hierarchies',
'iotae_cs_m4',
'iotae_cs_odata_advanced_thing_list',
'iotae_cs_odata_analytics_thing',
'iotae_cs_odata_bp_analytics_event_type',
'iotae_cs_odata_caching',
'iotae_cs_odata_geo_json',
'iotae_cs_odata_multi_lingual_support',
'iotae_cs_odata_postpackage',
'iotae_cs_odata_pst_property_types',
'iotae_cs_odata_thing_configuration_annotation',
'iotae_cs_odata_thing_configuration_object_association',
'iotae_cs_odata_thing_configuration_pst',
'iotae_cs_odata_thing_thing_association',
'iotae_cs_odata_thing_type_extension',
'iotae_cs_odata_thing_type_thing_configuration',
'iotae_cs_odata_unfied_events_pst',
'iotae_cs_odata_unified_events_config_event_types',
'iotae_cs_odata_unified_events_event_types_events',
'iotae_cs_odata_v2_thing_type_thing_configuration',
'iotae_cs_put_data_for_multiple_things',
'iotae_cs_reference_properties',
'iotae_cs_snapshot',
'iotae_cs_tenant_specific_validation',
'iotae_cs_thing_group',
'iotae_cs_thing_hierarchy',
'iotae_cs_thing_id',
'iotae_cs_thing_pst',
'iotae_cs_thing_template',
'iotae_cs_things',
'iotae_cs_things_validations',
'iotae_cs_thingtype_extension',
'iotae_cs_timeseries',
'iotae_cs_typedevents'
]

def aws_aehotfix_job = [
'Demo_Script',
'iotae_cs_alternateid',
'iotae_cs_analytics_thing',
'iotae_cs_bp_analytics_event_type',
'iotae_cs_caching',
'iotae_cs_composite_countries',
'iotae_cs_composite_customers',
'iotae_cs_composite_events',
'iotae_cs_composite_locations',
'iotae_cs_compositethings',
'iotae_cs_configuration_annotation',
'iotae_cs_configuration_main',
'iotae_cs_configuration_pst',
'iotae_cs_configuration_thingtypes',
'iotae_cs_detail_thing_sap',
'iotae_cs_event_severities',
'iotae_cs_event_statuses',
'iotae_cs_events',
'iotae_cs_events_aggregate',
'iotae_cs_events_aggregate_pdms',
'iotae_cs_events_validations',
'iotae_cs_file_services',
'iotae_cs_geo_json',
'iotae_cs_hierarchies',
'iotae_cs_m4',
'iotae_cs_odata_advanced_thing_list',
'iotae_cs_odata_analytics_thing',
'iotae_cs_odata_bp_analytics_event_type',
'iotae_cs_odata_caching',
'iotae_cs_odata_composite_events',
'iotae_cs_odata_composite_events_event_type',
'iotae_cs_odata_composite_things',
'iotae_cs_odata_geo_json',
'iotae_cs_odata_multi_lingual_support',
'iotae_cs_odata_postpackage',
'iotae_cs_odata_pst_property_types',
'iotae_cs_odata_thing_configuration_annotation',
'iotae_cs_odata_thing_configuration_object_association',
'iotae_cs_odata_thing_configuration_pst',
'iotae_cs_odata_thing_thing_association',
'iotae_cs_odata_thing_type_extension',
'iotae_cs_odata_thing_type_thing_configuration',
'iotae_cs_odata_unfied_events_pst',
'iotae_cs_odata_unified_events_config_event_types',
'iotae_cs_odata_unified_events_event_types_events',
'iotae_cs_odata_v2_thing_type_thing_configuration',
'iotae_cs_package_sharing',
'iotae_cs_put_data_for_multiple_things',
'iotae_cs_reference_properties',
'iotae_cs_snapshot',
'iotae_cs_tenant_specific_validation',
'iotae_cs_thing_group',
'iotae_cs_thing_hierarchy',
'iotae_cs_thing_hierarchy_pdms',
'iotae_cs_thing_id',
'iotae_cs_thing_pst',
'iotae_cs_thing_template',
'iotae_cs_things',
'iotae_cs_things_validations',
'iotae_cs_thingtype_extension',
'iotae_cs_timeseries',
'iotae_cs_typedevents'
]

String pipeline_flow_variable = "parameters: [string(name: 'JOB_NUMBER', value: '${BUILD_NUMBER}')], wait: true }"

String all_sic_commit_job = sic_commit_job.collect{"$it : { build job : '$it"}.join("', $pipeline_flow_variable, \n")
String all_aws_commit_job = aws_commit_job.collect{"$it : { build job : '$it"}.join("', $pipeline_flow_variable, \n")
String all_sic_staging_job = sic_staging_job.collect{"$it : { build job : '$it"}.join("', $pipeline_flow_variable, \n")
String all_aws_staging_job = aws_staging_job.collect{"$it : { build job : '$it"}.join("', $pipeline_flow_variable, \n")
String all_sic_aehotfix_job = sic_aehotfix_job.collect{"$it : { build job : '$it"}.join("', $pipeline_flow_variable, \n")
String all_aws_aehotfix_job = aws_aehotfix_job.collect{"$it : { build job : '$it"}.join("', $pipeline_flow_variable, \n")
String all_bd_job = job_bd.collect{"$it : { build job : '$it"}.join("', $pipeline_flow_variable, \n")

def giturl_dev = 'https://github.wdf.sap.corp/iot/IoTAE_Development.git'
def giturl_val = 'https://github.wdf.sap.corp/iot/IoTAE_Validation.git'
def giturl_rel = 'https://github.wdf.sap.corp/iot/IoTAE_Release.git'

String branch = '*/functional-test'

String goal_string = '.jmx -Dspace='
String goal_string2 = ' -Djob_num=${JOB_NUMBER}'

String env_inject_script = '''JOB_NUMBER=#$(printf "%04d" ${JOB_NUMBER})
echo JOB_NUMBER=${JOB_NUMBER}  > job_no.properties'''

String env_inject_file = 'job_no.properties'

for (space_item in dev_space)
{
    folder(space_item) 
    {
        description "This folder contains jmeter jobs for DEVELOPMENT space"
    }
}

for (space_item in val_space)
{
    folder(space_item) 
    {
        description "This folder contains jmeter jobs for VALIDATION space"
    }
}


for (item in aws_commit_job)
{
    String space_item = 'aws_commit'
    mavenJob("$space_item/$item") 
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
            timeout{
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
            extendedEmail {
                recipientList(mailRecipients_CS)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers {
                    aborted{
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
    pipelineJob("$space_item/Start_All") 
    {
      triggers 
        {
            cron("31 20 * * *")
        }
        definition 
        {
            cps 
            {
                script("pipeline{\nagent any \nstages{ \nstage('Start All')\n{ steps{ \nparallel ($all_aws_commit_job', $pipeline_flow_variable, $all_bd_job', $pipeline_flow_variable\n)\n}\n}\n}\n}")
                sandbox()
            }
        }   
    }
}
for (item_bd in job_bd)
{
    String space_item = 'aws_commit'
    mavenJob("$space_item/$item_bd") 
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
            timeout{
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
        goals("clean validate -DJMETER -DjMeterTestFile=$item_bd$goal_string$space_item$goal_string2")
        publishers 
        {
            extendedEmail {
                recipientList(mailRecipients_BD)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers {
                    aborted{
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
}

for (item in sic_commit_job)
{   
    String space_item = 'sic_commit'
    mavenJob("$space_item/$item") 
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
            timeout{
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
            extendedEmail {
                recipientList(mailRecipients_CS)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers {
                    aborted{
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
    pipelineJob("$space_item/Start_All") 
    {
      triggers 
        {
           // cron("31 20 * * *")
        }
        definition 
        {
            cps 
            {
                script("pipeline{\nagent any \nstages{ \nstage('Start All')\n{ steps{ \nparallel ($all_sic_commit_job', $pipeline_flow_variable, $all_bd_job', $pipeline_flow_variable\n)\n}\n}\n}\n}")
                sandbox()
            }
        }   
    }
}

for (item_bd in job_bd)
{    
    String space_item = 'sic_commit'
    mavenJob("$space_item/$item_bd") 
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
            timeout{
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
        goals("clean validate -DJMETER -DjMeterTestFile=$item_bd$goal_string$space_item$goal_string2")
        publishers 
        {
            extendedEmail {
                recipientList(mailRecipients_BD)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers {
                    aborted{
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
}

for (item in aws_staging_job)
{
    String space_item = 'aws_staging'
    mavenJob("$space_item/$item") 
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
            timeout{
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
            extendedEmail {
                recipientList(mailRecipients_CS)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers {
                    aborted{
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
    pipelineJob("$space_item/Start_All") 
    {
      triggers 
        {
            cron("31 20 * * *")
        }
        definition 
        {
            cps 
            {
                script("pipeline{\nagent any \nstages{ \nstage('Start All')\n{ steps{ \nparallel ($all_aws_staging_job', $pipeline_flow_variable, $all_bd_job', $pipeline_flow_variable\n)\n}\n}\n}\n}")
                sandbox()
            }
        }   
    }    
}
for (item_bd in job_bd)
{
    String space_item = 'aws_staging'
    mavenJob("$space_item/$item_bd") 
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
            timeout{
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
        goals("clean validate -DJMETER -DjMeterTestFile=$item_bd$goal_string$space_item$goal_string2")
        publishers 
        {
            extendedEmail {
                recipientList(mailRecipients_BD)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers {
                    aborted{
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
}

for (item in sic_aehotfix_job)
{
    String space_item = 'sic_aehotfix'
    mavenJob("$space_item/$item") 
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
            timeout{
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
            extendedEmail {
                recipientList(mailRecipients_CS)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers {
                    aborted{
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
    pipelineJob("$space_item/Start_All") 
    {
      triggers 
        {
            //cron("31 20 * * *")
        }
        definition 
        {
            cps 
            {
                script("pipeline{\nagent any \nstages{ \nstage('Start All')\n{ steps{ \nparallel ($all_sic_aehotfix_job', $pipeline_flow_variable, $all_bd_job', $pipeline_flow_variable\n)\n}\n}\n}\n}")
                sandbox()
            }
        }   
    }
}
for (item_bd in job_bd)
{
    String space_item = 'sic_aehotfix'
    mavenJob("$space_item/$item_bd") 
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
            timeout{
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
        goals("clean validate -DJMETER -DjMeterTestFile=$item_bd$goal_string$space_item$goal_string2")
        publishers 
        {
            extendedEmail {
                recipientList(mailRecipients_BD)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers {
                    aborted{
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
}

for (item in aws_aehotfix_job)
{
    String space_item = 'aws_aehotfix'
    mavenJob("$space_item/$item") 
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
            timeout{
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
            extendedEmail {
                recipientList(mailRecipients_CS)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers {
                    aborted{
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
    pipelineJob("$space_item/Start_All") 
    {
      triggers 
        {
            cron("31 20 * * *")
        }
        definition 
        {
            cps 
            {
                script("pipeline{\nagent any \nstages{ \nstage('Start All')\n{ steps{ \nparallel ($all_aws_aehotfix_job', $pipeline_flow_variable, $all_bd_job', $pipeline_flow_variable\n)\n}\n}\n}\n}")
                sandbox()
            }
        }   
    }    
}
for (item_bd in job_bd)
{
    String space_item = 'aws_aehotfix'
    mavenJob("$space_item/$item_bd") 
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
            timeout{
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
        goals("clean validate -DJMETER -DjMeterTestFile=$item_bd$goal_string$space_item$goal_string2")
        publishers 
        {
            extendedEmail {
                recipientList(mailRecipients_BD)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers {
                    aborted{
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
}

for (item in sic_staging_job)
{
    String space_item = 'sic_staging'
    mavenJob("$space_item/$item") 
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
            timeout{
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
            extendedEmail {
                recipientList(mailRecipients_CS)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers {
                    aborted{
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
    pipelineJob("$space_item/Start_All") 
    {
      triggers 
        {
           // cron("31 20 * * *")
        }
        definition 
        {
            cps 
            {
                script("pipeline{\nagent any \nstages{ \nstage('Start All')\n{ steps{ \nparallel ($all_sic_staging_job', $pipeline_flow_variable, $all_bd_job', $pipeline_flow_variable\n)\n}\n}\n}\n}")
                sandbox()
            }
        }   
    }
}

for (item_bd in job_bd)
{
    String space_item = 'sic_staging'
    mavenJob("$space_item/$item_bd") 
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
            timeout{
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
        goals("clean validate -DJMETER -DjMeterTestFile=$item_bd$goal_string$space_item$goal_string2")
        publishers 
        {
            extendedEmail {
                recipientList(mailRecipients_BD)
                defaultSubject("Job Failed")
                defaultContent('$BUILD_URL')
                triggers {
                    aborted{
                        subject('Job $JOB_NAME$BUILD_DISPLAY_NAME aborted')
                    }
                }
            }
        }
    }
}

for (space_item in rel_space)
{
    folder(space_item) 
    {
        description "This folder contains jmeter jobs for"
    }
}

sectionedView('Bots')
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
                    name("$item")
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
                    name("$item")
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
            name('RELEASE TEST JMETER BOTS')
            width('FULL')
            alignment('LEFT')
            jobs 
            {
                for (item in rel_space)
                {
                    name("$item")
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
